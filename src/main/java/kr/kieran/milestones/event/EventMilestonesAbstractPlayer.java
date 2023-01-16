package kr.kieran.milestones.event;

import com.massivecraft.massivecore.event.EventMassiveCore;
import kr.kieran.milestones.entity.MPlayer;
import org.bukkit.entity.Player;

public abstract class EventMilestonesAbstractPlayer extends EventMassiveCore
{
    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private final MPlayer mplayer;
    public MPlayer getMPlayer() { return mplayer; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public EventMilestonesAbstractPlayer(Player player) { this(MPlayer.get(player)); }
    public EventMilestonesAbstractPlayer(MPlayer mplayer)
    {
        this.mplayer = mplayer;
    }

    public EventMilestonesAbstractPlayer(boolean async, Player player) { this(async, MPlayer.get(player)); }
    public EventMilestonesAbstractPlayer(boolean async, MPlayer mplayer)
    {
        super(async);
        this.mplayer = mplayer;
    }

}
