package fr.silenthill99.topluck.inventory.hook.modo;

import fr.silenthill99.topluck.ItemBuilder;
import fr.silenthill99.topluck.Main;
import fr.silenthill99.topluck.inventory.AbstractInventory;
import fr.silenthill99.topluck.inventory.InventoryManager;
import fr.silenthill99.topluck.inventory.InventoryType;
import fr.silenthill99.topluck.inventory.holder.modo.PlayerChooseHolder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class PlayerChooseInventory extends AbstractInventory<PlayerChooseHolder>
{
    Main main = Main.getInstance();
    public PlayerChooseInventory()
    {
        super(PlayerChooseHolder.class);
    }

    @Override
    public void openInventory(Player player, Object... args)
    {
        PlayerChooseHolder holder = new PlayerChooseHolder();
        Inventory inv = createInventory(holder, 54, "Choisissez un joueur");
        int slot = 0;
        for (Player target : Bukkit.getOnlinePlayers())
        {
            holder.players.put(slot, target);
            inv.setItem(slot++, new ItemBuilder(Material.PLAYER_HEAD).setSkullOwner(target).setName(ChatColor.YELLOW + "TopLuck de " + target.getName()).toItemStack());
        }
        player.openInventory(inv);
    }

    @Override
    public void manageInventory(InventoryClickEvent event, ItemStack current, Player player, PlayerChooseHolder holder)
    {
        Player target = holder.players.get(event.getSlot());
        File file = new File(main.getDataFolder(), "Players/" + target.getName() + ".yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        switch (current.getType())
        {
            case PLAYER_HEAD:
            {
                InventoryManager.openInventory(player, InventoryType.TOPLUCK, target, file, config);
                break;
            }
            default:
            {
                break;
            }
        }
    }
}
