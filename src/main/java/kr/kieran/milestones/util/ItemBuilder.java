package kr.kieran.milestones.util;

import com.massivecraft.massivecore.util.Txt;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class ItemBuilder extends ItemStack
{

    private final Material material;
    private String itemName;
    private List<String> itemLore;

    private ItemBuilder(Material material)
    {
        this.material = material;
    }

    public static ItemBuilder newBuilder(Material material)
    {
        return new ItemBuilder(material);
    }

    public ItemBuilder name(String itemName)
    {
        this.itemName = Txt.parse(itemName);
        return this;
    }

    public ItemBuilder lore(List<String> itemLore)
    {
        this.itemLore = Txt.parse(itemLore);
        return this;
    }

    public ItemStack build()
    {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(itemName);
        meta.setLore(itemLore);
        item.setItemMeta(meta);
        return item;
    }

}
