package fr.silenthill99.topluck.inventory.hook.modo;

import fr.silenthill99.topluck.ItemBuilder;
import fr.silenthill99.topluck.inventory.AbstractInventory;
import fr.silenthill99.topluck.inventory.holder.modo.TopLuckHolder;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;

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
        File file = (File) args[1];
        YamlConfiguration configuration = (YamlConfiguration) args[2];

        TopLuckHolder holder = new TopLuckHolder(target, file, configuration);

        ItemStack tete = new ItemBuilder(Material.PLAYER_HEAD).setSkullOwner(target).toItemStack();
        Inventory inv = createInventory(holder, 27, "TopLuck de " + target.getName());
        inv.setItem(0, tete);
        player.openInventory(inv);
    }

    @Override
    public void manageInventory(InventoryClickEvent event, ItemStack current, Player player, TopLuckHolder holder)
    {
        Player target = (Player) holder.getTarget();
        File file = holder.getFile();
        YamlConfiguration config = holder.getConfig();
    }
}
