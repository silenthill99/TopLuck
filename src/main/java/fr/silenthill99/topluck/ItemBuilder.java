package fr.silenthill99.topluck;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ItemBuilder {

    private final ItemStack is;
    private final ItemMeta im;

    public ItemBuilder(ItemStack is) {
        this.is = is;
        this.im = is.getItemMeta();
    }

    public ItemBuilder(Material m, int amount) {
        this.is = new ItemStack(m, amount);
        this.im = is.getItemMeta();
    }

    public ItemBuilder(Material m) {
        this(m, 1);
    }

    public ItemBuilder setName(String name) {
        im.setDisplayName(name);
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setSkullOwner(OfflinePlayer owner) {
        SkullMeta skull = (SkullMeta) im;
        skull.setOwningPlayer(owner);
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        im.setLore(Arrays.asList(lore));
        is.setItemMeta(im);
        return this;
    }

    public ItemStack toItemStack() {
        return is;
    }
}
