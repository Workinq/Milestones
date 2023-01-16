package kr.kieran.milestones.entity.internal;

import kr.kieran.milestones.MilestonesPlugin;
import kr.kieran.milestones.entity.MPlayer;
import kr.kieran.milestones.entity.internal.milestone.MilestoneRequirement;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.HashSet;
import java.util.Set;

public abstract class MilestoneAbstract implements Listener
{
    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    protected MilestoneAbstract()
    {
        // Event
        Bukkit.getPluginManager().registerEvents(this, MilestonesPlugin.get());

        // Debug
        MilestonesPlugin.get().debug(this.getClass().getSimpleName(), "has been instanced");
    }

    protected Set<MilestoneRequirement> milestoneRequirements = new HashSet<>();

    protected MilestoneRequirement getCurrentMilestoneRequirement(int previousValue, int newValue)
    {
        MilestoneRequirement currentMilestoneRequirement = null;
        for (MilestoneRequirement milestoneRequirement : milestoneRequirements)
        {
            Integer requirementAmount = milestoneRequirement.getRequirementAmount();
            if (previousValue < requirementAmount && newValue >= requirementAmount)
            {
                currentMilestoneRequirement = milestoneRequirement;
                break;
            }
        }
        return currentMilestoneRequirement;
    }

    protected void completeMilestone(MPlayer mplayer, MilestoneRequirement milestoneRequirement)
    {
//        mplayer.addCompletedMilestone(milestoneId);
//        MixinCommand.get().dispatchCommand(mplayer, Txt.parse(milestoneRewardCommand, mplayer.getName()));

        // Inform
//        mplayer.msg(MConf.get().completedMilestoneMsg, milestoneName);
    }

    protected boolean isMilestoneAlreadyCompleted(MPlayer mplayer)
    {
        return false;
//        return mplayer.getCompletedMilestoneIds().contains(milestoneId);
    }

}
