package kr.kieran.milestones.event;

import kr.kieran.milestones.entity.MPlayer;
import org.bukkit.Material;
import org.bukkit.event.HandlerList;

public class EventMilestonesItemCraft extends EventMilestonesAbstractPlayer
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

    private final Material craftedItemType;
    public Material getCraftedItemType() { return craftedItemType; }

    private final Integer previousItemsCrafted;
    public Integer getPreviousItemsCrafted() { return previousItemsCrafted; }

    private Integer newItemsCrafted;
    public Integer getNewItemsCrafted() { return newItemsCrafted; }
    public void setNewItemsCrafted(Integer newItemsCrafted) { this.newItemsCrafted = newItemsCrafted; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public EventMilestonesItemCraft(MPlayer mplayer, Material craftedItemType, Integer previousItemsCrafted, Integer newItemsCrafted)
    {
        super(mplayer);
        this.craftedItemType = craftedItemType;
        this.previousItemsCrafted = previousItemsCrafted;
        this.newItemsCrafted = newItemsCrafted;
    }

}
