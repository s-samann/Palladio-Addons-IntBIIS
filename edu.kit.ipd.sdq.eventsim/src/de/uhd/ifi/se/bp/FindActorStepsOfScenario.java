package de.uhd.ifi.se.bp;

import java.util.LinkedHashSet;
import java.util.Set;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.Activity;
import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep;
import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.BpusagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.command.usage.FindActionInUsageBehaviour;

/**
 * Searches for and returns all elements of type {@link ActorStep} contained in the given usage
 * scenario.
 * 
 * @author Robert Heinrich
 * 
 */
public class FindActorStepsOfScenario implements IPCMCommand<Set<ActorStep>> {

	private UsageScenario scenario;

    /**
     * Constructs a command that returns all actor steps contained in the given usage
     * scenario.
     * 
     * @param scenario
     *            the usage scenario
     */
    public FindActorStepsOfScenario(UsageScenario scenario) {
        this.scenario = scenario;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<ActorStep> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        ScenarioBehaviour behaviour = scenario.getScenarioBehaviour_UsageScenario();
        return findActorSteps(behaviour, executor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

    /**
     * Searches for and returns all actor steps that are contained in the specified scenario
     * behavior
     */
    private Set<ActorStep> findActorSteps(ScenarioBehaviour behaviour, ICommandExecutor<PCMModel> executor) {
        Set<ActorStep> actorSteps = new LinkedHashSet<ActorStep>();

        // find start action
        AbstractUserAction currentAction = executor.execute(new FindActionInUsageBehaviour<Start>(behaviour,
                Start.class));
        while (currentAction != null) {
            if (BpusagemodelPackage.eINSTANCE.getActorStep().isInstance(currentAction)) {
                actorSteps.add((ActorStep) currentAction);
            } else if (BpusagemodelPackage.eINSTANCE.getActivity().isInstance(currentAction)) {
            	actorSteps.addAll(findActorStepsInActivity((Activity) currentAction, executor));
            } else if (UsagemodelPackage.eINSTANCE.getBranch().isInstance(currentAction)) {
                actorSteps.addAll(findActorStepsInBranch((Branch) currentAction, executor));
            } else if (UsagemodelPackage.eINSTANCE.getLoop().isInstance(currentAction)) {
                actorSteps.addAll(findActorStepsInLoop((Loop) currentAction, executor));
            }
            currentAction = currentAction.getSuccessor();
        }
        return actorSteps;
    }

    /**
     * Searches for and returns all actor steps that are contained in the specified activity.
     */
    private Set<ActorStep> findActorStepsInActivity (Activity action, ICommandExecutor<PCMModel> executor){
			
    	ScenarioBehaviour behaviour = action.getScenario();
        return findActorSteps(behaviour, executor);
	}

	/**
     * Searches for and returns all actor steps that are contained in the specified branch.
     */
    private Set<ActorStep> findActorStepsInBranch(Branch action, ICommandExecutor<PCMModel> executor) {
        Set<ActorStep> actorSteps = new LinkedHashSet<ActorStep>();
        for (BranchTransition t : action.getBranchTransitions_Branch()) {
            ScenarioBehaviour behaviour = t.getBranchedBehaviour_BranchTransition();
            actorSteps.addAll(findActorSteps(behaviour, executor));
        }
        return actorSteps;
    }

    /**
     * Searches for and returns all actor steps that are contained in the specified loop.
     */
    private Set<ActorStep> findActorStepsInLoop(Loop action, ICommandExecutor<PCMModel> executor) {
        ScenarioBehaviour behaviour = action.getBodyBehaviour_Loop();
        return findActorSteps(behaviour, executor);
    }


}
