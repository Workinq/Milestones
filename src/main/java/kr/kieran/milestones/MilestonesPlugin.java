package kr.kieran.milestones;

import com.massivecraft.massivecore.MassivePlugin;
import com.massivecraft.massivecore.util.MUtil;
import kr.kieran.milestones.entity.MConf;
import kr.kieran.milestones.entity.MConfColl;
import kr.kieran.milestones.entity.MPlayerColl;
import kr.kieran.milestones.entity.MilestoneConfColl;

import java.util.List;

public class MilestonesPlugin extends MassivePlugin
{
    // -------------------------------------------- //
    // INSTANCE & CONSTRUCT
    // -------------------------------------------- //

    private static MilestonesPlugin i;
    public static MilestonesPlugin get() { return i; }
    public MilestonesPlugin() { MilestonesPlugin.i = this; }

    public void debug(Object... msg)
    {
        if (!MConf.get().debug) return;
        this.log(msg);
    }

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public void onEnableInner()
    {
        this.activateAuto();
    }

    @Override
    public List<Class<?>> getClassesActiveColls()
    {
        return MUtil.list(
                MConfColl.class,
                MPlayerColl.class,
                MilestoneConfColl.class
        );
    }

}
