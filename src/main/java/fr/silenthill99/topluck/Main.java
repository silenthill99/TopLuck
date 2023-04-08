package fr.silenthill99.topluck;

import fr.silenthill99.topluck.commands.TopLuck;
import fr.silenthill99.topluck.inventory.InventoryManager;
import fr.silenthill99.topluck.listener.Events;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance()
    {
        return instance;
    }
    @Override
    public void onEnable()
    {
        instance = this;
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new InventoryManager(), this);
        pm.registerEvents(new Events(), this);
        commands();
        saveDefaultConfig();
    }

    private void commands()
    {
        getCommand("topluck").setExecutor(new TopLuck());
    }

    @Override
    public void onDisable()
    {

    }
}
