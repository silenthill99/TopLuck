package fr.silenthill99.topluck;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ItemBuilder
{
    private final ItemStack is;

    public ItemBuilder(ItemStack is)
    {
        this.is = is;
    }

    public ItemBuilder(Material m, int amount)
    {
        is = new ItemStack(m, amount);
    }

    public ItemBuilder(Material m)
    {
        this(m, 1);
    }

    public ItemBuilder clone()
    {
        return new ItemBuilder(is);
    }

    public ItemBuilder setName(String name)
    {
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setLore(String... lore)
    {
        ItemMeta im = is.getItemMeta();
        im.setLore(Arrays.asList(lore));
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setSkullOwner(OfflinePlayer owner)
    {
        SkullMeta im = (SkullMeta) is.getItemMeta();
        im.setOwningPlayer(owner);
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder addGlowingEffects()
    {
        ItemMeta im = is.getItemMeta();
        im.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        is.setItemMeta(im);
        return this;
    }

    public ItemStack toItemStack()
    {
        return is;
    }
}
