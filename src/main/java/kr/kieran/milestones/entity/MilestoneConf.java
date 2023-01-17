package kr.kieran.milestones.entity;

import com.massivecraft.massivecore.command.editor.annotation.EditorName;
import com.massivecraft.massivecore.store.Entity;
import com.massivecraft.massivecore.util.MUtil;
import kr.kieran.milestones.entity.internal.milestone.MilestoneAbstract;
import kr.kieran.milestones.entity.internal.milestone.MilestoneBlock;
import kr.kieran.milestones.entity.internal.milestone.MilestoneCombat;
import kr.kieran.milestones.entity.internal.milestone.MilestoneCraft;
import kr.kieran.milestones.entity.internal.milestone.MilestoneIsland;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.stellardev.galacticskyblock.entity.Island;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@EditorName("config")
public class MilestoneConf extends Entity<MilestoneConf>
{
    // -------------------------------------------- //
    // META
    // -------------------------------------------- //

    protected static transient MilestoneConf i;
    public static MilestoneConf get() { return i; }

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    // Stores a list of all the combat milestones
    public List<MilestoneCombat> combatMilestones = MUtil.list(
            new MilestoneCombat(1, 100000, EntityType.ZOMBIE, 100),
            new MilestoneCombat(2, 99000, EntityType.ZOMBIE, 1000),
            new MilestoneCombat(3, 98000, EntityType.ZOMBIE, 10000)
    );

    // Stores a list of all the island milestones
    public List<MilestoneIsland> islandMilestones = MUtil.list(
            new MilestoneIsland(4, 100000, 100),
            new MilestoneIsland(5, 99000, 1000),
            new MilestoneIsland(6, 98000, 10000)
    );

    // Stores a list of all the crafting milestones
    public List<MilestoneCraft> craftingMilestones = MUtil.list(
            new MilestoneCraft(7, 100000, Material.DIAMOND_HELMET, 10),
            new MilestoneCraft(8, 99000, Material.DIAMOND_HELMET, 100),
            new MilestoneCraft(9, 98000, Material.DIAMOND_HELMET, 1000)
    );

    // Stores a list of all the block breaking milestones
    public List<MilestoneBlock> blockBreakMilestones = MUtil.list(
            new MilestoneBlock(10, 100000, Material.STONE, 100),
            new MilestoneBlock(11, 99000, Material.STONE, 1000),
            new MilestoneBlock(12, 98000, Material.STONE, 10000)
    );

    // -------------------------------------------- //
    // FIELD: combatMilestones
    // -------------------------------------------- //

    public Optional<MilestoneCombat> getNextCombatMilestoneForPlayer(MPlayer mplayer, EntityType typeOfEntity)
    {
        Integer totalEntityKills = mplayer.getTotalKillsFromEntity(typeOfEntity);
        return combatMilestones.stream().filter(milestone -> totalEntityKills > milestone.getKillsNecessary()).max(Comparator.comparingInt(MilestoneAbstract::getPriority));
    }

    // -------------------------------------------- //
    // FIELD: islandMilestones
    // -------------------------------------------- //

    public Optional<MilestoneIsland> getNextIslandMilestoneForPlayer(Island island)
    {
        int islandLevel = island.getLevel();
        return islandMilestones.stream().filter(milestone -> islandLevel > milestone.getIslandLevel()).max(Comparator.comparingInt(MilestoneAbstract::getPriority));
    }

    // -------------------------------------------- //
    // FIELD: craftingMilestones
    // -------------------------------------------- //

    public Optional<MilestoneCraft> getNextCraftingMilestoneForPlayer(MPlayer mplayer, Material itemToCraft)
    {
        Integer totalItemCrafts = mplayer.getTotalItemCraftsFromMaterial(itemToCraft);
        return craftingMilestones.stream().filter(milestone -> totalItemCrafts > milestone.getNumberOfTimesCrafted()).max(Comparator.comparingInt(MilestoneAbstract::getPriority));
    }

    // -------------------------------------------- //
    // FIELD: blockBreakMilestones
    // -------------------------------------------- //

    public Optional<MilestoneBlock> getNextBlockBreakMilestoneForPlayer(MPlayer mplayer, Material typeOfBlock)
    {
        Integer totalBlockBreaks = mplayer.getTotalBlocksMinedFromMaterial(typeOfBlock);
        return blockBreakMilestones.stream().filter(milestone -> totalBlockBreaks > milestone.getNecessaryTimesMined()).max(Comparator.comparingInt(MilestoneAbstract::getPriority));
    }

    // -------------------------------------------- //
    // OVERRIDE: ENTITY
    // -------------------------------------------- //

    @Override
    public MilestoneConf load(MilestoneConf that)
    {
        super.load(that);
        return this;
    }

}
