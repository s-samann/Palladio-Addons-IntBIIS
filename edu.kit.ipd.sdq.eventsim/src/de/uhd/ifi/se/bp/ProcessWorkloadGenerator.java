package de.uhd.ifi.se.bp;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ProcessTriggerPeriod;
import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ProcessWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.IEntityListener;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.events.BeginUsageTraversalEvent;
import edu.kit.ipd.sdq.eventsim.workload.IWorkloadGenerator;

/**
 * The {@link ProcessWorkloadGenerator} generates the workload for the corresponding process. A workload generates a new {@link User}, i.e. BP instance, as soon as a specified time duration has passed
 * since the previous user has been created. This time duration between two subsequent user arrivals
 * is called the inter-arrival time. The inter-arrival time may differ for each {@link ProcessTriggerPeriod}. 
 * 
 * @author Robert Heinrich
 * 
 */
public class ProcessWorkloadGenerator implements IWorkloadGenerator{

    private static final Logger logger = Logger.getLogger(ProcessWorkloadGenerator.class);
    
	private final EventSimModel model;
    private final ProcessWorkload workload;
    private final EList<ProcessTriggerPeriod> periods;
    private final IRegionBasedGarbageCollector<RequestContext> blackboardGarbageCollector;
	
	/**
     * Constructs a process workload in accordance with the specified workload description.
     * 
     * @param model
     *            the model
     * @param workload
     *            the workload description
     */
    public ProcessWorkloadGenerator(final EventSimModel model, final ProcessWorkload workload) {
        this.model = model;
        this.workload = workload;
        this.periods = workload.getProcessTriggerPeriods();
        this.blackboardGarbageCollector = this.model.getProbeSpecContext().getBlackboardGarbageCollector();
    }
	
	
	@Override
	public void processWorkload() {
		// spawn initial user
		// the initial user starts at the beginning of the first ProcessTriggerPeriod
        this.spawnUser(periods.get(0).getPeriodStartTimePoint());	
	}
	
	/**
     * Creates a new user and schedules the next user to enter the system after the inter-arrival time 
     * of the corresponding {@link ProcessTriggerPeriod} has passed.
     */
    private void spawnUser(double waitingTime) {
    	
    	// create the user
        final UsageScenario scenario = this.workload.getUsageScenario_Workload();
        final User user = new User(this.model, scenario);
        
        logger.info("create a new user");
        
        // when the user entered the process, we wait until the inter-arrival time has passed and then
        // schedule a new one
        user.addEntityListener(new IEntityListener() {

            @Override
            public void leftSystem() {
                ProcessWorkloadGenerator.this.blackboardGarbageCollector.leaveRegion(user.getRequestContext()
                        .rootContext());
                ProcessWorkloadGenerator.this.model.increaseMainMeasurementsCount();
            }

            @Override
            public void enteredSystem() {
                ProcessWorkloadGenerator.this.blackboardGarbageCollector.enterRegion(user.getRequestContext()
                        .rootContext());
                
                logger.info("process instance started execution of " + scenario.getEntityName() + " at " + model.getSimulationControl().getCurrentSimulationTime());
                
                // determine the current simulation time. This is the time the actual user started
                double currentTime = model.getSimulationControl().getCurrentSimulationTime();
                
                ProcessTriggerPeriod currentPeriod = null;
                
                // determine the current ProcessTriggerPeriod
                Iterator<ProcessTriggerPeriod> l = periods.iterator();
                while(l.hasNext())
                {
                	currentPeriod = l.next();
                	if((currentTime >= currentPeriod.getPeriodStartTimePoint()) && (currentTime <= currentPeriod.getPeriodEndTimePoint())){
                		break;
                	}
                }    
                   
                // determine the waiting time between the actual user and the next user based on the inter-arrival time of the current period
                final double waitingTime = StackContext.evaluateStatic(currentPeriod.getInterArrivalTime_ProcessWorkload().getSpecification(), Double.class);
                
                // the potential start time point of the next user
                double nextStart = currentTime + waitingTime;
                
                Iterator<ProcessTriggerPeriod> i = periods.iterator();
                // flag that shows whether nextStart is located within a ProcessTriggerPeriod
                boolean containedInPeriod = false;
                
                // determine whether nextStart is located within one of the ProcessTriggerPeriods 
                while(i.hasNext()){
                	
                	currentPeriod = i.next();
                	
                	// if nextStart is located within the ProcessTriggerPeriods
                	if((nextStart >= currentPeriod.getPeriodStartTimePoint()) && (nextStart <= currentPeriod.getPeriodEndTimePoint())){
                		 
                		// create a new user after the waiting time, i.e. at the next start time point
                        ProcessWorkloadGenerator.this.spawnUser(waitingTime);
                        containedInPeriod = true;
                        break;
                	}
                }
                
                
                // we know that nextStart is NOT already located within a ProcessTriggerPeriod
                if(!containedInPeriod)
                {
                	Iterator<ProcessTriggerPeriod> j = periods.iterator();
                
                	// determine whether nextStart is located between two ProcessTriggerPeriods
                	while(j.hasNext()){
                	
                		currentPeriod = j.next();
                	
                		if (nextStart < currentPeriod.getPeriodStartTimePoint()){
                		
                			// create a new user at the beginning of the ProcessTriggerPeriod
                			ProcessWorkloadGenerator.this.spawnUser(currentPeriod.getPeriodStartTimePoint() - currentTime);
                			break;
                		}
                	}
                }
            }
            
            

        });
        
        new BeginUsageTraversalEvent(this.model, scenario).schedule(user, waitingTime);
    }
    

}
