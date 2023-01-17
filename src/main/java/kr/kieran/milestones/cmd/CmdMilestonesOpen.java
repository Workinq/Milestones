package kr.kieran.milestones.cmd;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import kr.kieran.milestones.gui.MainMenuGui;
import org.bukkit.entity.Player;

public class CmdMilestonesOpen extends MilestonesCommand
{
    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public CmdMilestonesOpen()
    {
        // Requirement
        this.addRequirements(RequirementIsPlayer.get());
    }

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public void perform() throws MassiveException
    {
        Player sender = msender.getPlayer();
        sender.openInventory(MainMenuGui.get().getInventory());
    }

}
