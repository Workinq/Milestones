package kr.kieran.milestones.event;

import kr.kieran.milestones.entity.MPlayer;
import org.bukkit.Material;
import org.bukkit.event.HandlerList;

public class EventMilestonesBlockBreak extends EventMilestonesAbstractPlayer
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

    private final Material minedBlockType;
    public Material getMinedBlockType() { return minedBlockType; }

    private final Integer previousBlocksBroken;
    public Integer getPreviousBlocksBroken() { return previousBlocksBroken; }

    private Integer newBlocksBroken;
    public Integer getNewBlocksBroken() { return newBlocksBroken; }
    public void setNewBlocksBroken(Integer newBlocksBroken) { this.newBlocksBroken = newBlocksBroken; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public EventMilestonesBlockBreak(MPlayer mplayer, Material minedBlockType, Integer previousBlocksBroken, Integer newBlocksBroken)
    {
        super(mplayer);
        this.minedBlockType = minedBlockType;
        this.previousBlocksBroken = previousBlocksBroken;
        this.newBlocksBroken = newBlocksBroken;
    }

}
