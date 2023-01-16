package kr.kieran.milestones.entity.internal.block;

import kr.kieran.milestones.entity.MPlayer;
import kr.kieran.milestones.entity.internal.MilestoneAbstract;
import kr.kieran.milestones.entity.internal.milestone.MilestoneRequirement;
import kr.kieran.milestones.event.EventMilestonesBlockBreak;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;

import java.util.Set;

public class MilestoneBlockBreak extends MilestoneAbstract
{

    private final Set<Material> trackedBlocks;

    public MilestoneBlockBreak(Set<Material> trackedBlocks)
    {
        this.trackedBlocks = trackedBlocks;
    }

    @EventHandler
    public void onBreakBlock(EventMilestonesBlockBreak event)
    {
        Material minedBlockType = event.getMinedBlockType();
        if (!trackedBlocks.contains(minedBlockType)) return;

        Integer previousBlocksBroken = event.getPreviousBlocksBroken();
        Integer newBlocksBroken = event.getNewBlocksBroken();

        // Fetch the milestone the player is working toward
        MilestoneRequirement currentMilestoneRequirement = this.getCurrentMilestoneRequirement(previousBlocksBroken, newBlocksBroken);
        if (currentMilestoneRequirement == null) return;

        // The player has completed the milestone
        MPlayer mplayer = event.getMPlayer();
        this.completeMilestone(mplayer, currentMilestoneRequirement);
    }

}
