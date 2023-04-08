package fr.silenthill99.topluck.inventory.hook.modo;

import fr.silenthill99.topluck.inventory.AbstractInventory;
import fr.silenthill99.topluck.inventory.holder.modo.TopLuckHolder;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TopLuckInventory extends AbstractInventory<TopLuckHolder>
{
    public TopLuckInventory()
    {
        super(TopLuckHolder.class);
    }

    @Override
    public void openInventory(Player player, Object... args)
    {
        Player target = (Player) args[0];
        TopLuckHolder holder = new TopLuckHolder(target);

        Inventory inv = createInventory(holder, 27, "TopLuck de " + target.getName());
        player.openInventory(inv);
    }

    @Override
    public void manageInventory(InventoryClickEvent event, ItemStack current, Player player, TopLuckHolder holder)
    {
        Player target = (Player) holder.getTarget();
    }
}
