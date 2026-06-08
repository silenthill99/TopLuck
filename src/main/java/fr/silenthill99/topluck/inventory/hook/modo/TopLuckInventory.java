package fr.silenthill99.topluck.inventory.hook.modo;

import fr.silenthill99.topluck.ItemBuilder;
import fr.silenthill99.topluck.Main;
import fr.silenthill99.topluck.inventory.AbstractInventory;
import fr.silenthill99.topluck.inventory.InventoryManager;
import fr.silenthill99.topluck.inventory.InventoryType;
import fr.silenthill99.topluck.inventory.holder.modo.TopLuckHolder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.Objects;

public class TopLuckInventory extends AbstractInventory<TopLuckHolder> {
    Main main = Main.getInstance();
    public TopLuckInventory() {
        super(TopLuckHolder.class);
    }

    @Override
    public void openInventory(Player player, Object... args) {
        Player target = (Player) args[0];
        TopLuckHolder holder = new TopLuckHolder(target);

        ItemStack head = new ItemBuilder(Material.PLAYER_HEAD).setSkullOwner(target).toItemStack();
        ItemStack diamond = new ItemBuilder(Material.DIAMOND_ORE).setName("Taux de diamants minés")
                .setLore(checkTaux(target, "blocks.diamond")).toItemStack();
        ItemStack gold = new ItemBuilder(Material.GOLD_ORE).setName("Taux d'or minés")
                .setLore(checkTaux(target, "blocks.gold")).toItemStack();
        ItemStack teleport = new ItemBuilder(Material.ENDER_PEARL).setName(ChatColor.GREEN + "Se téléporter")
                .toItemStack();
        ItemStack inventaire = new ItemBuilder(Material.CHEST).setName(ChatColor.YELLOW + "Voir l'inventaire")
                .toItemStack();
        ItemStack deepslateDiamond = new ItemBuilder(Material.DEEPSLATE_DIAMOND_ORE).setName("Taux de diamant des abîmes minés")
                .setLore(checkTaux(target, "blocks.deepslate_diamond")).toItemStack();
        ItemStack deepslateGold = new ItemBuilder(Material.DEEPSLATE_GOLD_ORE).setName("Taux d'or des abîmes minés")
                .setLore(checkTaux(target, "blocks.deepslate_gold")).toItemStack();
        ItemStack avertir = new ItemBuilder(Material.FIREWORK_ROCKET).setName(ChatColor.YELLOW + "Avertir").toItemStack();

        Inventory inv = createInventory(holder, 27, "TopLuck | " + target.getName());
        inv.setItem(0, head);
        inv.setItem(8, avertir);
        inv.setItem(9, diamond);
        inv.setItem(10, gold);
        inv.setItem(11, deepslateDiamond);
        inv.setItem(12, deepslateGold);
        inv.setItem(18, teleport);
        inv.setItem(19, inventaire);
        player.openInventory(inv);
    }

    @Override
    public void manageInventory(InventoryClickEvent event, ItemStack current, Player player, TopLuckHolder holder) {
        Player target = holder.getTarget();
        if (target == null) {
            player.closeInventory();
            player.sendMessage(ChatColor.RED + "Le joueur s'est déconnecté !");
            return;
        }
        switch (current.getType()) {
            case ENDER_PEARL: {
                player.teleport(target);
                break;
            }
            case CHEST: {
                InventoryManager.openInventory(player, InventoryType.INVSEE, target);
                break;
            }
            case FIREWORK_ROCKET: {
                target.sendTitle(ChatColor.RED + "Passe TS", ChatColor.AQUA + "reddawn-pvp.skailarhost.com", 20, 100, 20);
                Objects.requireNonNull(target.getLocation().getWorld()).playSound(target, Sound.ENTITY_WITHER_DEATH, 5, 10);
                break;
            }
        }
    }

    private String checkTaux(Player player, String path) {
        File file = main.createPlayerFile(player);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        double minerai = config.getDouble(path);
        double stone = config.getDouble("blocks.stone");
        if (stone == 0) return "0%";
        double taux = (minerai / stone) * 100;
        return taux + "%";
    }
}
