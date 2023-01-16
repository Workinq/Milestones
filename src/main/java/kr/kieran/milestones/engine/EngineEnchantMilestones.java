package kr.kieran.milestones.engine;

import com.massivecraft.massivecore.Engine;
import kr.kieran.milestones.entity.MPlayer;
import kr.kieran.milestones.event.EventMilestonesItemEnchant;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.Map;

public class EngineEnchantMilestones extends Engine
{
    // -------------------------------------------- //
    // INSTANCE
    // -------------------------------------------- //

    private static EngineEnchantMilestones i = new EngineEnchantMilestones();
    public static EngineEnchantMilestones get() { return i; }

    // -------------------------------------------- //
    // EVENT: ITEM ENCHANT
    // -------------------------------------------- //

    @EventHandler(ignoreCancelled = true)
    public void onEnchantItem(EnchantItemEvent event)
    {
        // The player has crafted an item
        MPlayer mplayer = MPlayer.get(event.getEnchanter());
        ItemStack enchantedItem = event.getItem();
        if (enchantedItem == null) return;
        Map<Enchantment, Integer> enchantsToAdd = Collections.unmodifiableMap(event.getEnchantsToAdd());

        // Event
        Integer previousItemsEnchanted = mplayer.getItemsEnchanted();
        Integer newItemsEnchanted = previousItemsEnchanted + 1;
        EventMilestonesItemEnchant mevent = new EventMilestonesItemEnchant(mplayer, enchantedItem, enchantsToAdd, previousItemsEnchanted, newItemsEnchanted);
        mevent.run();
        newItemsEnchanted = mevent.getNewItemEnchants();

        // Apply
        mplayer.setItemsEnchanted(newItemsEnchanted);
    }

}
