package kr.kieran.milestones.engine;

import com.massivecraft.massivecore.Engine;
import kr.kieran.milestones.entity.MPlayer;
import kr.kieran.milestones.event.EventMilestonesItemCraft;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class EngineCraftMilestones extends Engine
{
    // -------------------------------------------- //
    // INSTANCE
    // -------------------------------------------- //

    private static EngineCraftMilestones i = new EngineCraftMilestones();
    public static EngineCraftMilestones get() { return i; }

    // -------------------------------------------- //
    // EVENT: ITEM CRAFT
    // -------------------------------------------- //

    @EventHandler(ignoreCancelled = true)
    public void onCraftItem(CraftItemEvent event)
    {
        if (event.getResult() != Event.Result.ALLOW) return;

        // The player has crafted an item
        MPlayer mplayer = MPlayer.get(event.getWhoClicked());
        ItemStack craftedItem = event.getCurrentItem();
        if (craftedItem == null) return;
        Material material = craftedItem.getType();

        // Event
        Integer previousItemsCrafted = mplayer.getTotalItemCraftsFromMaterial(material);
        Integer newItemsCrafted = previousItemsCrafted + craftedItem.getAmount();
        EventMilestonesItemCraft mevent = new EventMilestonesItemCraft(mplayer, material, previousItemsCrafted, newItemsCrafted);
        mevent.run();
        newItemsCrafted = mevent.getNewItemsCrafted();

        // Apply
        mplayer.setTotalItemCraftsForMaterial(material, newItemsCrafted);
    }

}
