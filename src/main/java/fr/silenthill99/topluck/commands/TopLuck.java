package fr.silenthill99.topluck.commands;

import fr.silenthill99.topluck.Main;
import fr.silenthill99.topluck.inventory.InventoryManager;
import fr.silenthill99.topluck.inventory.InventoryType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class TopLuck implements CommandExecutor
{

    Main main = Main.getInstance();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (args.length == 0)
        {
            InventoryManager.openInventory(player, InventoryType.PLAYER_CHOOSE);
            return false;
        }

        if (args.length >= 2)
        {
            player.sendMessage(ChatColor.RED + "Veuillez faire /topluck [player]");
            return false;
        }

        OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

        if (!target.isOnline())
        {
            player.sendMessage(ChatColor.RED + "Erreur ! Ce joueur n'est pas connecté ou n'existe pas !");
            return false;
        }

        File file = new File(main.getDataFolder(), "Players/" + target.getName() + ".yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        InventoryManager.openInventory(player, InventoryType.TOPLUCK, target, file, config);

        return false;
    }
}
