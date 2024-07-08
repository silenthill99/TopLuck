package fr.silenthill99.topluck.listener;

import fr.silenthill99.topluck.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Events implements Listener {
    Main main = Main.getInstance();
    public static final List<Material> SAVED_BLOCKS = Arrays.asList(Material.STONE, Material.DIAMOND_ORE,
            Material.GOLD_ORE);

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        File file = main.createPlayerFile(player);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        if (!player.hasPlayedBefore()) {
            config.set("blocks.stone", 0);
            config.set("blocks.diamond", 0);
            config.set("blocks.gold", 0);
        }
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) throws IOException {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if (!SAVED_BLOCKS.contains(block.getType()))
            return;
        File file = main.createPlayerFile(player);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        String name = block.getType().name().toLowerCase();
        config.set("blocks." + name, config.getDouble("blocks." + name) + 1);
        config.save(file);
    }
}
