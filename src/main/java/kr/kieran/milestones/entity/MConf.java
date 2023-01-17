package kr.kieran.milestones.entity;

import com.massivecraft.massivecore.command.editor.annotation.EditorName;
import com.massivecraft.massivecore.store.Entity;
import com.massivecraft.massivecore.util.MUtil;
import org.bukkit.Material;

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
    // GUI: MAIN MENU
    // -------------------------------------------- //

    public String mainGuiTitle = "<bad><bold>Milestones";
    public int mainGuiRows = 3;

    // Items
    public Material mainGuiCombatMaterial = Material.DIAMOND_SWORD;
    public String mainGuiCombatName = "<info>Combat Milestones";
    public List<String> mainGuiCombatLore = MUtil.list("", "<gray>Left-click to show all completed and", "<gray>uncompleted combat milestones.");
    public int mainGuiCombatSlot = 0;

    public Material mainGuiIslandMaterial = Material.GRASS;
    public String mainGuiIslandName = "<info>Island Milestones";
    public List<String> mainGuiIslandLore = MUtil.list("", "<gray>Left-click to show all completed and", "<gray>uncompleted island milestones.");
    public int mainGuiIslandSlot = 2;

    public Material mainGuiCraftMaterial = Material.WORKBENCH;
    public String mainGuiCraftName = "<info>Crafting Milestones";
    public List<String> mainGuiCraftLore = MUtil.list("", "<gray>Left-click to show all completed and", "<gray>uncompleted crafting milestones.");
    public int mainGuiCraftSlot = 4;

    public Material mainGuiBlockMaterial = Material.DIAMOND_PICKAXE;
    public String mainGuiBlockName = "<info>Block Breaking Milestones";
    public List<String> mainGuiBlockLore = MUtil.list("", "<gray>Left-click to show all completed and", "<gray>uncompleted block breaking milestones.");
    public int mainGuiBlockSlot = 6;

    public Material mainGuiMiscMaterial = Material.EXP_BOTTLE;
    public String mainGuiMiscName = "<info>Miscellaneous Milestones";
    public List<String> mainGuiMiscLore = MUtil.list("", "<gray>Left-click to show all completed and", "<gray>uncompleted miscellaneous milestones.");
    public int mainGuiMiscSlot = 8;

    public Material mainGuiEnchantMaterial = Material.ENCHANTMENT_TABLE;
    public String mainGuiEnchantName = "<info>Enchanting Milestones";
    public List<String> mainGuiEnchantLore = MUtil.list("", "<gray>Left-click to show all completed and", "<gray>uncompleted enchanting milestones.");
    public int mainGuiEnchantSlot = 10;

    public Material mainGuiFishMaterial = Material.FISHING_ROD;
    public String mainGuiFishName = "<info>Fishing Milestones";
    public List<String> mainGuiFishLore = MUtil.list("", "<gray>Left-click to show all completed and", "<gray>uncompleted fishing milestones.");
    public int mainGuiFishSlot = 12;

    public Material mainGuiAlchemyMaterial = Material.BREWING_STAND_ITEM;
    public String mainGuiAlchemyName = "<info>Alchemy Milestones";
    public List<String> mainGuiAlchemyLore = MUtil.list("", "<gray>Left-click to show all completed and", "<gray>uncompleted alchemy milestones.");
    public int mainGuiAlchemySlot = 14;
    
    public Material mainGuiAdventureMaterial = Material.EMPTY_MAP;
    public String mainGuiAdventureName = "<info>Adventure Milestones";
    public List<String> mainGuiAdventureLore = MUtil.list("", "<gray>Left-click to show all completed and", "<gray>uncompleted adventure milestones.");
    public int mainGuiAdventureSlot = 16;

    // -------------------------------------------- //
    // DEBUG
    // -------------------------------------------- //

    public boolean debug = true;

}
