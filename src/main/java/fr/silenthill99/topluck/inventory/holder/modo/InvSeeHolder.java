package fr.silenthill99.topluck.inventory.holder.modo;

import fr.silenthill99.topluck.inventory.SilenthillHolder;
import org.bukkit.entity.Player;

public class InvSeeHolder extends SilenthillHolder {

    private final Player target;

    public InvSeeHolder(Player target) {
        this.target = target;
    }

    public Player getTarget() {
        return target;
    }
}
