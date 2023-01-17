package kr.kieran.milestones.cmd;

import com.massivecraft.massivecore.MassiveException;
import kr.kieran.milestones.entity.MConf;

import java.util.Collections;
import java.util.List;

public class CmdMilestones extends MilestonesCommand
{
    // -------------------------------------------- //
    // INSTANCE
    // -------------------------------------------- //

    private static CmdMilestones i = new CmdMilestones();
    public static CmdMilestones get() { return i; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public CmdMilestones()
    {
    }

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    public CmdMilestonesOpen cmdMilestonesOpen = new CmdMilestonesOpen();

    // -------------------------------------------- //
    // PERFORM
    // -------------------------------------------- //

    @Override
    public void perform() throws MassiveException
    {
        if (msender.isPlayer())
        {
            cmdMilestonesOpen.execute(sender, Collections.emptyList());
            return;
        }

        super.perform();
    }

    // -------------------------------------------- //
    // ALIASES
    // -------------------------------------------- //

    @Override
    public List<String> getAliases()
    {
        return MConf.get().aliasesM;
    }

}
