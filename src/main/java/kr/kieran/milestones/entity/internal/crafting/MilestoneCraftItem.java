package kr.kieran.milestones.entity.internal.crafting;

import kr.kieran.milestones.entity.MPlayer;
import kr.kieran.milestones.event.EventMilestonesItemCraft;
import org.bukkit.event.EventHandler;

public class MilestoneCraftItem
{

    @EventHandler(ignoreCancelled = true)
    public void onCraftItem(EventMilestonesItemCraft event)
    {
        //if (!materialsToTrack.contains(event.getCraftedItemType())) return;

        // The player has crafted an item
        MPlayer mplayer = event.getMPlayer();
        //if (this.isMilestoneAlreadyCompleted(mplayer)) return;

        /*if (event.getNewItemsCrafted() > milestoneRequirement)
        {
            // The player has completed the milestone
            this.completeMilestone(mplayer);
        }*/
    }

}
