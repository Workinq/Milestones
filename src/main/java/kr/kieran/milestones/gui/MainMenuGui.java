package kr.kieran.milestones.gui;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.chestgui.ChestActionAbstract;
import com.massivecraft.massivecore.chestgui.ChestGui;
import com.massivecraft.massivecore.util.Txt;
import kr.kieran.milestones.MilestoneCategory;
import kr.kieran.milestones.entity.MConf;
import kr.kieran.milestones.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MainMenuGui
{
    // -------------------------------------------- //
    // INSTANCE
    // -------------------------------------------- //

    private static MainMenuGui i = new MainMenuGui();
    public static MainMenuGui get() { return i; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public MainMenuGui()
    {
        mainMenuGui = this.getGui();
    }

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private ChestGui mainMenuGui;

    // -------------------------------------------- //
    // FIELD: mainMenuGui
    // -------------------------------------------- //

    public ChestGui getGui()
    {
        if (mainMenuGui != null) return mainMenuGui;

        mainMenuGui = ChestGui.getCreative(Bukkit.createInventory(null, MConf.get().mainGuiRows * 9, Txt.parse(MConf.get().mainGuiTitle)));

        // Properties
        mainMenuGui.setAutoclosing(false);
        mainMenuGui.setAutoremoving(false);
        mainMenuGui.setBottomInventoryAllow(true);

        // Items
        // Combat
        mainMenuGui.getInventory().setItem(MConf.get().mainGuiCombatSlot, ItemBuilder.newBuilder(MConf.get().mainGuiCombatMaterial).name(MConf.get().mainGuiCombatName).lore(MConf.get().mainGuiCombatLore).build());
        mainMenuGui.setAction(MConf.get().mainGuiCombatSlot, new MilestoneCategoryClickAction(MilestoneCategory.COMBAT));

        // Island
        mainMenuGui.getInventory().setItem(MConf.get().mainGuiIslandSlot, ItemBuilder.newBuilder(MConf.get().mainGuiIslandMaterial).name(MConf.get().mainGuiIslandName).lore(MConf.get().mainGuiIslandLore).build());
        mainMenuGui.setAction(MConf.get().mainGuiIslandSlot, new MilestoneCategoryClickAction(MilestoneCategory.ISLAND));

        // Crafting
        mainMenuGui.getInventory().setItem(MConf.get().mainGuiCraftSlot, ItemBuilder.newBuilder(MConf.get().mainGuiCraftMaterial).name(MConf.get().mainGuiCraftName).lore(MConf.get().mainGuiCraftLore).build());
        mainMenuGui.setAction(MConf.get().mainGuiCraftSlot, new MilestoneCategoryClickAction(MilestoneCategory.CRAFT));

        // Block Break
        mainMenuGui.getInventory().setItem(MConf.get().mainGuiBlockSlot, ItemBuilder.newBuilder(MConf.get().mainGuiBlockMaterial).name(MConf.get().mainGuiBlockName).lore(MConf.get().mainGuiBlockLore).build());
        mainMenuGui.setAction(MConf.get().mainGuiBlockSlot, new MilestoneCategoryClickAction(MilestoneCategory.BLOCK));

        // Miscellaneous
        mainMenuGui.getInventory().setItem(MConf.get().mainGuiMiscSlot, ItemBuilder.newBuilder(MConf.get().mainGuiMiscMaterial).name(MConf.get().mainGuiMiscName).lore(MConf.get().mainGuiMiscLore).build());
        mainMenuGui.setAction(MConf.get().mainGuiMiscSlot, new MilestoneCategoryClickAction(MilestoneCategory.MISCELLANEOUS));

        // Enchanting
        mainMenuGui.getInventory().setItem(MConf.get().mainGuiEnchantSlot, ItemBuilder.newBuilder(MConf.get().mainGuiEnchantMaterial).name(MConf.get().mainGuiEnchantName).lore(MConf.get().mainGuiEnchantLore).build());
        mainMenuGui.setAction(MConf.get().mainGuiEnchantSlot, new MilestoneCategoryClickAction(MilestoneCategory.ENCHANT));

        // Fishing
        mainMenuGui.getInventory().setItem(MConf.get().mainGuiFishSlot, ItemBuilder.newBuilder(MConf.get().mainGuiFishMaterial).name(MConf.get().mainGuiFishName).lore(MConf.get().mainGuiFishLore).build());
        mainMenuGui.setAction(MConf.get().mainGuiFishSlot, new MilestoneCategoryClickAction(MilestoneCategory.FISH));

        // Alchemy
        mainMenuGui.getInventory().setItem(MConf.get().mainGuiAlchemySlot, ItemBuilder.newBuilder(MConf.get().mainGuiAlchemyMaterial).name(MConf.get().mainGuiAlchemyName).lore(MConf.get().mainGuiAlchemyLore).build());
        mainMenuGui.setAction(MConf.get().mainGuiAlchemySlot, new MilestoneCategoryClickAction(MilestoneCategory.ALCHEMY));

        // Adventure
        mainMenuGui.getInventory().setItem(MConf.get().mainGuiAdventureSlot, ItemBuilder.newBuilder(MConf.get().mainGuiAdventureMaterial).name(MConf.get().mainGuiAdventureName).lore(MConf.get().mainGuiAdventureLore).build());
        mainMenuGui.setAction(MConf.get().mainGuiAdventureSlot, new MilestoneCategoryClickAction(MilestoneCategory.ADVENTURE));

        return mainMenuGui;
    }

    public Inventory getInventory() throws MassiveException
    {
        if (mainMenuGui == null) throw new MassiveException().setMsg("mainMenuGui must be instanced first");
        return mainMenuGui.getInventory();
    }

    // -------------------------------------------- //
    // INVENTORY ACTION
    // -------------------------------------------- //

    private static class MilestoneCategoryClickAction extends ChestActionAbstract
    {

        private final MilestoneCategory category;

        public MilestoneCategoryClickAction(MilestoneCategory category)
        {
            this.category = category;
        }

        @Override
        public boolean onClick(InventoryClickEvent event, Player player)
        {
            // Never allow clicks
            event.setCancelled(true);

            // Open desired menu
            switch (category)
            {
            }

            return true;
        }

    }

}
