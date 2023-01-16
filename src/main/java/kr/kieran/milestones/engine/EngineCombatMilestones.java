package kr.kieran.milestones.engine;

import com.massivecraft.massivecore.Engine;
import kr.kieran.milestones.entity.MPlayer;
import kr.kieran.milestones.event.EventMilestonesEntityKill;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

public class EngineCombatMilestones extends Engine
{
    // -------------------------------------------- //
    // INSTANCE
    // -------------------------------------------- //

    private static EngineCombatMilestones i = new EngineCombatMilestones();
    public static EngineCombatMilestones get() { return i; }

    // -------------------------------------------- //
    // EVENT: ENTITY DEATH
    // -------------------------------------------- //

    @EventHandler(ignoreCancelled = true)
    public void onKilLEntity(EntityDeathEvent event)
    {
        // An entity has been killed by a player
        LivingEntity killedEntity = event.getEntity();
        Player potentialKiller = killedEntity.getKiller();
        if (potentialKiller == null) return;
        MPlayer mplayer = MPlayer.get(potentialKiller);
        EntityType entityType = killedEntity.getType();

        // Event
        Integer previousEntityKills = mplayer.getTotalKillsFromEntity(entityType);
        Integer newEntityKills = previousEntityKills + 1;
        EventMilestonesEntityKill mevent = new EventMilestonesEntityKill(mplayer, entityType, previousEntityKills, newEntityKills);
        mevent.run();
        newEntityKills = mevent.getNewEntityKills();

        // Apply
        mplayer.setTotalKillsForEntity(entityType, newEntityKills);
    }

}
