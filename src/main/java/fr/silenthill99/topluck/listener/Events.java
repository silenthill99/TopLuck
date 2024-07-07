package fr.silenthill99.topluck.listener;

import fr.silenthill99.topluck.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.io.File;
import java.io.IOException;

public class Events implements Listener {
    Main main = Main.getInstance();
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) throws IOException {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        File file = main.createPlayerFile(player);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        if (block.getType() == Material.STONE) {
            config.set("blocks.stone", config.getDouble("blocks.stone") + 1);
        }
        if (block.getType() == Material.DIAMOND_ORE) {
            config.set("blocks.diamond", config.getDouble("blocks.diamond") + 1);
        }
        if (block.getType() == Material.GOLD_ORE) {
            config.set("blocks.gold", config.getDouble("blocks.gold") + 1);
        }
        config.save(file);
    }

    @EventHandler
    public void onTakeDamages(EntityDamageEvent event){
        if (!(event.getEntity() instanceof Player)) return;
        event.setCancelled(true);
    }
}
