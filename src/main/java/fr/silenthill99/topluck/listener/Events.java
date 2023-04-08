package fr.silenthill99.topluck.listener;

import fr.silenthill99.topluck.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Events implements Listener
{
    Main main = Main.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        File file = new File(main.getDataFolder(), "Players/" + player.getName() + ".yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        if (!player.hasPlayedBefore())
            config.set("Date de 1ère connection", new Date());
        config.set("Date de dernière connection", new Date());
        config.set("ID", player.getUniqueId().toString());
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
