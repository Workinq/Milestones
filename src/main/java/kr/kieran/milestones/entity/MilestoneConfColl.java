package kr.kieran.milestones.entity;

import com.massivecraft.massivecore.MassiveCore;
import com.massivecraft.massivecore.store.Coll;
import kr.kieran.milestones.MilestonesPlugin;
import kr.kieran.milestones.entity.internal.milestone.MilestoneAbstract;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MilestoneConfColl extends Coll<MilestoneConf>
{
    // -------------------------------------------- //
    // INSTANCE
    // -------------------------------------------- //

    private static MilestoneConfColl i = new MilestoneConfColl();
    public static MilestoneConfColl get() { return i; }

    // -------------------------------------------- //
    // STACK TRACEABILITY
    // -------------------------------------------- //

    @Override
    public void onTick()
    {
        super.onTick();
    }

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public void setActive(boolean active)
    {
        super.setActive(active);
        if (!active) return;
        MilestoneConf.i = this.get(MassiveCore.INSTANCE, true);
    }

    @Override
    public void postAttach(MilestoneConf entity, String id)
    {
        super.postAttach(entity, id);

        // Check for duplicate IDs in MilestoneConf
        List<MilestoneAbstract> allMilestones = new ArrayList<>();
        allMilestones.addAll(entity.combatMilestones);
        allMilestones.addAll(entity.islandMilestones);
        allMilestones.addAll(entity.craftingMilestones);

        Set<Integer> discoveredIds = new HashSet<>();
        for (MilestoneAbstract milestone : allMilestones)
        {
            boolean addedNewElement = discoveredIds.add(milestone.getId());
            if (!addedNewElement)
            {
                // Send mean looking warning
                MilestonesPlugin.get().log("Matching ID in MilestoneConf for", milestone);
                MilestonesPlugin.get().log("ALL IDs MUST BE UNIQUE OR MALFUNCTION WILL OCCUR");
                MilestonesPlugin.get().log("IF IDs ARE NOT UNIQUE MILESTONES CANNOT BE TOLD APART");
                MilestonesPlugin.get().log("ALL IDs MUST BE UNIQUE OR MALFUNCTION WILL OCCUR");

                // Sleep to make sure the warning is seen
                try
                {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(5));
                }
                catch (InterruptedException ignored)
                {
                }
                return;
            }
        }
    }

}
