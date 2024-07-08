package fr.silenthill99.topluck;

import fr.silenthill99.topluck.commands.TopLuckCommand;
import fr.silenthill99.topluck.inventory.InventoryManager;
import fr.silenthill99.topluck.listener.Events;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Le plugin est opérationnel !");
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new InventoryManager(), this);
        pm.registerEvents(new Events(), this);
        commands();
    }

    private void commands() {
        getCommand("topluck").setExecutor(new TopLuckCommand());
    }

    public File createPlayerFile(Player player) {
        File file = new File(getDataFolder(), "Players/" + player.getName() + ".yml");
        if (!file.exists()) {
            try {
                file.mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return file;
    }
}
