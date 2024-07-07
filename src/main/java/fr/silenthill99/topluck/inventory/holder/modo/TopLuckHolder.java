package fr.silenthill99.topluck.inventory.holder.modo;

import fr.silenthill99.topluck.inventory.SilenthillHolder;
import org.bukkit.entity.Player;

public class TopLuckHolder extends SilenthillHolder {
    private final Player target;

    public TopLuckHolder(Player target) {
        this.target = target;
    }

    public Player getTarget() {
        return target;
    }
}
