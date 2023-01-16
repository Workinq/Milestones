package kr.kieran.milestones.engine;

import com.massivecraft.massivecore.Engine;
import kr.kieran.milestones.entity.MPlayer;
import kr.kieran.milestones.event.EventMilestonesBlockBreak;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

public class EngineBlockMilestones extends Engine
{
    // -------------------------------------------- //
    // INSTANCE
    // -------------------------------------------- //

    private static EngineBlockMilestones i = new EngineBlockMilestones();
    public static EngineBlockMilestones get() { return i; }

    // -------------------------------------------- //
    // EVENT: BLOCK BREAK
    // -------------------------------------------- //

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event)
    {
        // The player has mined a block
        MPlayer mplayer = MPlayer.get(event.getPlayer());
        Material material = event.getBlock().getType();

        // Event
        Integer previousBlocksBroken = mplayer.getTotalBlocksMinedFromMaterial(material);
        Integer newBlocksBroken = previousBlocksBroken + 1;
        EventMilestonesBlockBreak mevent = new EventMilestonesBlockBreak(mplayer, material, previousBlocksBroken, newBlocksBroken);
        mevent.run();
        newBlocksBroken = mevent.getNewBlocksBroken();

        // Apply
        mplayer.setTotalBlocksMinedForMaterial(material, newBlocksBroken);
    }

}
