package de.uhd.ifi.se.bp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.WorkingPeriod;
import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.simucomframework.resources.SimSimpleFairPassiveResource;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.resources.ResourceFactory;
import edu.kit.ipd.sdq.pcm.simulation.bpscheduler.SuspendableFCFSResource;

/**
 * Factory for creating active and passive BP resources
 * 
 * @author Robert Heinrich
 * 
 */
public class BPResourceFactory {
	
	
	/**
     * Creates an active resource in accordance with the given resource specification.
     * 
     * @param model
     *            the simulation model
     * @param specification
     *            the resource specification
     * @return the created resource
     */
    public static SimActiveResource createActiveResource(final EventSimModel model, ActorResource specification) {
  
    	ProcessingResourceSpecification spec = ResourceenvironmentFactory.eINSTANCE.createProcessingResourceSpecification();
    	    	
    	// load scheduling policy from resource type model
    	ResourceSet resSet = new ResourceSetImpl();
    	Resource resource = resSet.getResource(URI.createURI("pathmap://BUSINESS_PROCESS_SCHEDULER_MODELS/BusinessProcessSchedulers.resourcetype"), true);
    	ResourceRepository repository = (ResourceRepository) resource.getContents().get(0); 
    	SchedulingPolicy schedulingPolicy = repository.getSchedulingPolicies__ResourceRepository().get(0);
    	
        // set default values of attributes not contained in human actor specification
    	spec.setNumberOfReplicas(1);
    	final PCMRandomVariable processingRate = CoreFactory.eINSTANCE.createPCMRandomVariable();
    	processingRate.setSpecification("1");
    	spec.setProcessingRate_ProcessingResourceSpecification(processingRate);
    	spec.setSchedulingPolicy(schedulingPolicy);
   
    	// call the original resource factory 
    	SimActiveResource result = ResourceFactory.createActiveResource(model, spec);
    	
    	SuspendableFCFSResource x = (SuspendableFCFSResource)result.getSchedulerResource();
    	
    	// SuspendEvent is fired at the beginning of the simulation
    	new SuspendEvent(model, "suspend", specification.getWorkingPeriods()).schedule(x,0);
    	
    	return result;
    }
    
    /**
     * Creates a passive resource in accordance with the given resource specification.
     * 
     * @param model
     *            the simulation model
     * @param specification
     *            the resource specification
     * @return the created resource
     */
    public static SimPassiveResource createPassiveResource(final EventSimModel model,
            final DeviceResource specification) {
    	
    	// obtain capacity by evaluating the associated StoEx
        final PCMRandomVariable capacitySpecification = specification.getCapacity();
        final int capacity = StackContext.evaluateStatic(capacitySpecification.getSpecification(), Integer.class);

        final String name = specification.getEntityName();
        final String resourceId = specification.getId();
        // set dummy assembly context id
        final String assemblyContextId = "BusinessProcessContext";
        final String combinedId = specification.getId();

        IPassiveResource schedulerResource = new SimSimpleFairPassiveResource(model, capacity, name, resourceId, assemblyContextId, combinedId, false);
        
        return new SimPassiveResource(model, schedulerResource);
    }
    
    private static class SuspendEvent extends AbstractSimEventDelegator<SuspendableFCFSResource> {
    	
    	private EList<WorkingPeriod> periods;

        protected SuspendEvent(ISimulationModel model, String name, EList<WorkingPeriod> periods) {
            super(model, name);
            this.periods = periods;
        }

        @Override
        public void eventRoutine(SuspendableFCFSResource resource) {
            resource.suspend();
            
            double currentTime = this.getModel().getSimulationControl().getCurrentSimulationTime();
            double nextResume = 0;
            for (WorkingPeriod p: periods){
            	// as we are in suspend state we know that we are between two working periods
            	// find the start time of the working period next to the current simulation time
            	if (currentTime <= p.getPeriodStartTimePoint()){
            		
            		nextResume = p.getPeriodStartTimePoint() - currentTime;
            		new ResumeEvent(getModel(), "resume", periods).schedule(resource, nextResume);
            		
            		break;
            	}
            	
            }
            
        }

    }

    private static class ResumeEvent extends AbstractSimEventDelegator<SuspendableFCFSResource> {

    	private EList<WorkingPeriod> periods;
    	
        protected ResumeEvent(ISimulationModel model, String name, EList<WorkingPeriod> periods) {
            super(model, name);
            this.periods = periods;
        }

        @Override
        public void eventRoutine(SuspendableFCFSResource resource) {
            resource.resume();
            
            double currentTime = this.getModel().getSimulationControl().getCurrentSimulationTime();
            double nextSuspend = 0;
            
            for (WorkingPeriod p: periods){
            	// as we are in running state we know that we are in a working period
            	// find the working period
            	if ((currentTime >= p.getPeriodStartTimePoint()) && (currentTime<= p.getPeriodEndTimePoint())){
            		
            		// suspend at the end of the working period
            		nextSuspend = p.getPeriodEndTimePoint() - currentTime;
            		new SuspendEvent(getModel(), "suspend", periods).schedule(resource, nextSuspend);
            		
            		break;
            	}
            	
            }
            
        }

    }
    

}
