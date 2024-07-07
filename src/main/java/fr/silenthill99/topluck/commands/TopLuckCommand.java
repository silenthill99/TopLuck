package fr.silenthill99.topluck.commands;

import fr.silenthill99.topluck.inventory.InventoryManager;
import fr.silenthill99.topluck.inventory.InventoryType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TopLuckCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label,
                             @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Cette commande ne peut être éxécutée par u n joueur !");
            return false;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            InventoryManager.openInventory(player, InventoryType.CHOOSE);
            return true;
        }

        if (args.length >= 2) {
            player.sendMessage(ChatColor.RED + "/topluck [joueur]");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(ChatColor.RED + "Ce joueur n'est pas connecté ou n'existe pas !");
            return false;
        }

        InventoryManager.openInventory(player, InventoryType.TOPLUCK, target);
        return true;
    }
}
