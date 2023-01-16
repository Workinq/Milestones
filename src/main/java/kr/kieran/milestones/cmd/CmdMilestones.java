package kr.kieran.milestones.cmd;

import kr.kieran.milestones.entity.MConf;

import java.util.List;

public class CmdMilestones extends MilestonesCommand
{
    // -------------------------------------------- //
    // INSTANCE
    // -------------------------------------------- //

    private static CmdMilestones i = new CmdMilestones();
    public static CmdMilestones get() { return i; }

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public List<String> getAliases()
    {
        return MConf.get().aliasesM;
    }

}
