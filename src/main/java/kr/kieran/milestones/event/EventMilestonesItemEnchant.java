package kr.kieran.milestones.event;

import kr.kieran.milestones.entity.MPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class EventMilestonesItemEnchant extends EventMilestonesAbstractPlayer
{
    // -------------------------------------------- //
    // REQUIRED EVENT CODE
    // -------------------------------------------- //

    private static final HandlerList handlers = new HandlerList();
    @Override public HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private final ItemStack itemBeingEnchanted;
    public ItemStack getItemBeingEnchanted() { return itemBeingEnchanted; }

    private final Map<Enchantment, Integer> appliedEnchants;
    public Map<Enchantment, Integer> getAppliedEnchants() { return appliedEnchants; }

    private final Integer previousItemEnchants;
    public Integer getPreviousItemEnchants() { return previousItemEnchants; }

    private Integer newItemEnchants;
    public Integer getNewItemEnchants() { return newItemEnchants; }
    public void setNewItemEnchants(Integer newItemEnchants) { this.newItemEnchants = newItemEnchants; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public EventMilestonesItemEnchant(MPlayer mplayer, ItemStack itemBeingEnchanted, Map<Enchantment, Integer> appliedEnchants, Integer previousItemEnchants, Integer newItemEnchants)
    {
        super(mplayer);
        this.itemBeingEnchanted = itemBeingEnchanted;
        this.appliedEnchants = appliedEnchants;
        this.previousItemEnchants = previousItemEnchants;
        this.newItemEnchants = newItemEnchants;
    }

}
