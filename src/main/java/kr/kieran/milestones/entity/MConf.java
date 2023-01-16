package kr.kieran.milestones.entity;

import com.massivecraft.massivecore.command.editor.annotation.EditorName;
import com.massivecraft.massivecore.store.Entity;
import com.massivecraft.massivecore.util.MUtil;

import java.util.List;

@EditorName("config")
public class MConf extends Entity<MConf>
{
    // -------------------------------------------- //
    // META
    // -------------------------------------------- //

    protected static transient MConf i;
    public static MConf get() { return i; }

    // -------------------------------------------- //
    // OVERRIDE: ENTITY
    // -------------------------------------------- //

    @Override
    public MConf load(MConf that)
    {
        super.load(that);
        return this;
    }

    // -------------------------------------------- //
    // COMMAND ALIASES
    // -------------------------------------------- //

    public List<String> aliasesM = MUtil.list("milestones");

    // -------------------------------------------- //
    // MESSAGES
    // -------------------------------------------- //

    public String completedMilestoneMsg = "<i>You completed the <d>%s <i>milestone.";

    // -------------------------------------------- //
    // DEBUG
    // -------------------------------------------- //

    public boolean debug = true;

}
