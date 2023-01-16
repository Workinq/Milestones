package kr.kieran.milestones.cmd;

import com.massivecraft.massivecore.command.MassiveCommand;
import kr.kieran.milestones.entity.MPlayer;

public class MilestonesCommand extends MassiveCommand
{
    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    public MPlayer msender;

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public MilestonesCommand()
    {
        this.setSetupEnabled(true);
    }

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public void senderFields(boolean set)
    {
        this.msender = set ? MPlayer.get(sender) : null;
    }

}
