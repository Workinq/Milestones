package kr.kieran.milestones.event;

import com.massivecraft.massivecore.event.EventMassiveCore;
import kr.kieran.milestones.entity.MPlayer;
import org.bukkit.command.CommandSender;

public abstract class EventMilestonesAbstractSender extends EventMassiveCore
{
    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private final CommandSender sender;
    public CommandSender getSender() { return this.sender; }
    public MPlayer getMPlayer() { return this.sender == null ? null : MPlayer.get(this.sender); }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public EventMilestonesAbstractSender(CommandSender sender)
    {
        this.sender = sender;
    }

    public EventMilestonesAbstractSender(boolean async, CommandSender sender)
    {
        super(async);
        this.sender = sender;
    }

}
