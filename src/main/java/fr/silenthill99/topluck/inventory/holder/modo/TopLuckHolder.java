package fr.silenthill99.topluck.inventory.holder.modo;

import fr.silenthill99.topluck.inventory.SilenthillHolder;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class TopLuckHolder extends SilenthillHolder
{
    private final OfflinePlayer target;
    private final File file;
    private final YamlConfiguration configuration;

    public TopLuckHolder(OfflinePlayer target, File file, YamlConfiguration configuration)
    {
        this.target = target;
        this.file = file;
        this.configuration = configuration;
    }

    public OfflinePlayer getTarget()
    {
        return this.target;
    }

    public File getFile()
    {
        return this.file;
    }

    public YamlConfiguration getConfig()
    {
        return this.configuration;
    }
}
