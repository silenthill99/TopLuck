package fr.silenthill99.topluck.inventory.holder.modo;

import fr.silenthill99.topluck.inventory.SilenthillHolder;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerChooseHolder extends SilenthillHolder
{
    public HashMap<Integer, Player> players = new HashMap<>();
}
