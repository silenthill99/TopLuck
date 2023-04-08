package fr.silenthill99.topluck.commands;

import fr.silenthill99.topluck.inventory.InventoryManager;
import fr.silenthill99.topluck.inventory.InventoryType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TopLuck implements CommandExecutor
{
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

        InventoryManager.openInventory(player, InventoryType.TOPLUCK, target);

        return false;
    }
}
