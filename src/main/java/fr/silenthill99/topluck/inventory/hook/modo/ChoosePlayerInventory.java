package fr.silenthill99.topluck.inventory.hook.modo;

import fr.silenthill99.topluck.ItemBuilder;
import fr.silenthill99.topluck.inventory.AbstractInventory;
import fr.silenthill99.topluck.inventory.InventoryManager;
import fr.silenthill99.topluck.inventory.InventoryType;
import fr.silenthill99.topluck.inventory.holder.modo.ChoosePlayerHolder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChoosePlayerInventory extends AbstractInventory<ChoosePlayerHolder> {
    public ChoosePlayerInventory() {
        super(ChoosePlayerHolder.class);
    }

    @Override
    public void openInventory(Player player, Object... args) {
        ChoosePlayerHolder holder = new ChoosePlayerHolder();

        Inventory inv = createInventory(holder, 54, "Top Luck");
        int slot = 0;
        for (Player target : Bukkit.getOnlinePlayers()) {
            holder.player.put(slot, target);
            inv.setItem(slot++, new ItemBuilder(Material.PLAYER_HEAD).setSkullOwner(target).toItemStack());
        }
        player.openInventory(inv);
    }

    @Override
    public void manageInventory(InventoryClickEvent event, ItemStack current, Player player, ChoosePlayerHolder holder) {
        Player target = holder.player.get(event.getSlot());
        if (target == null) {
            player.closeInventory();
            player.sendMessage(ChatColor.RED + "Le joueur s'est déconnecté !");
            return;
        }
        InventoryManager.openInventory(player, InventoryType.TOPLUCK, target);
    }
}
