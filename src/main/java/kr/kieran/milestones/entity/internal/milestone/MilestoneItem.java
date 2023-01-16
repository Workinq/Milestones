package kr.kieran.milestones.entity.internal.milestone;

import org.bukkit.Material;

import java.io.Serializable;
import java.util.List;

public class MilestoneItem implements Serializable
{
    // -------------------------------------------- //
    // CONSTANTS
    // -------------------------------------------- //

    private static final transient long serialVersionUID = 1L;

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private Material itemMaterial;
    public Material getItemMaterial() { return itemMaterial; }
    public void setItemMaterial(Material itemMaterial) { this.itemMaterial = itemMaterial; }

    private String itemName;
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    private List<String> itemLore;
    public List<String> getItemLore() { return itemLore; }
    public void setItemLore(List<String> itemLore) { this.itemLore = itemLore; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public MilestoneItem()
    {
        this(null, null, null);
    }

    public MilestoneItem(Material itemMaterial, String itemName, List<String> itemLore)
    {
        this.itemMaterial = itemMaterial;
        this.itemName = itemName;
        this.itemLore = itemLore;
    }

}
