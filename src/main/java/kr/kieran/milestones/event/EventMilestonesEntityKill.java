package kr.kieran.milestones.event;

import kr.kieran.milestones.entity.MPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.event.HandlerList;

public class EventMilestonesEntityKill extends EventMilestonesAbstractPlayer
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

    private final EntityType killedEntityType;
    public EntityType getKilledEntityType() { return killedEntityType; }

    private final Integer previousEntityKills;
    public Integer getPreviousEntityKills() { return previousEntityKills; }

    private Integer newEntityKills;
    public Integer getNewEntityKills() { return newEntityKills; }
    public void setNewEntityKills(Integer newEntityKills) { this.newEntityKills = newEntityKills; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public EventMilestonesEntityKill(MPlayer mplayer, EntityType killedEntityType, Integer previousEntityKills, Integer newEntityKills)
    {
        super(mplayer);
        this.killedEntityType = killedEntityType;
        this.previousEntityKills = previousEntityKills;
        this.newEntityKills = newEntityKills;
    }

}
