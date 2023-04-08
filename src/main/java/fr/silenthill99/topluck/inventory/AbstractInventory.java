package fr.silenthill99.topluck.inventory;

import fr.silenthill99.topluck.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractInventory<T extends SilenthillHolder>
{
    public static final ItemStack CLOSE = new ItemBuilder(Material.BARRIER).setName(ChatColor.YELLOW + "Fermer le menu").toItemStack();
    public static final ItemStack RETOUR = new ItemBuilder(Material.SUNFLOWER).setName(ChatColor.YELLOW + "Retour").toItemStack();

    private final Class<T> holderClass;

    public AbstractInventory(Class<T> holderClass)
    {
        this.holderClass = holderClass;
    }

    public boolean isInstance(SilenthillHolder nh)
    {
        return nh.getClass().isAssignableFrom(holderClass);
    }

    protected Inventory createInventory(T holder, int size, String titre)
    {
        return Bukkit.createInventory(holder, size, titre);
    }

    public void onJoin(PlayerJoinEvent event) {}
    public void onQuit(PlayerQuitEvent event) {}
    public abstract void openInventory(Player player, Object... args);
    public void manageInventory(InventoryClickEvent event, ItemStack current, Player player, T holder) {}
    public void voidInventory(InventoryClickEvent event, Player player, T holder) {}
    public void moveFromInventory(InventoryClickEvent event, Inventory inventory, Player player, T holder) {}
    public void closeInventory(Player player, InventoryCloseEvent event) {
    }
}