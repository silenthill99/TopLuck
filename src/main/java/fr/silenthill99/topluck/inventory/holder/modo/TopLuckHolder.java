package fr.silenthill99.topluck.inventory.holder.modo;

import fr.silenthill99.topluck.inventory.SilenthillHolder;
import org.bukkit.OfflinePlayer;

public class TopLuckHolder extends SilenthillHolder
{
    private final OfflinePlayer target;

    public TopLuckHolder(OfflinePlayer target)
    {
        this.target = target;
    }

    public OfflinePlayer getTarget()
    {
        return this.target;
    }
}
