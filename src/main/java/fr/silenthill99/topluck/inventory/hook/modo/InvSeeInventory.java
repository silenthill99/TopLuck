package fr.silenthill99.topluck.inventory.hook.modo;

import fr.silenthill99.topluck.inventory.AbstractInventory;
import fr.silenthill99.topluck.inventory.holder.modo.InvSeeHolder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;

public class InvSeeInventory extends AbstractInventory<InvSeeHolder> {
    public InvSeeInventory() {
        super(InvSeeHolder.class);
    }

    @Override
    public void openInventory(Player player, Object... args) {
        Player target = (Player) args[0];

        InvSeeHolder holder = new InvSeeHolder(target);
        Inventory inv = createInventory(holder, 54, "Inventaire de " + target.getName());
        for (int slot = 0; slot < 36; slot++) {
            inv.setItem(slot, target.getInventory().getItem(slot));
        }
        inv.setItem(36, target.getInventory().getItem(EquipmentSlot.HEAD));
        inv.setItem(37, target.getInventory().getItem(EquipmentSlot.CHEST));
        inv.setItem(38, target.getInventory().getItem(EquipmentSlot.LEGS));
        inv.setItem(39, target.getInventory().getItem(EquipmentSlot.FEET));
        inv.setItem(40, target.getInventory().getItemInOffHand());
        player.openInventory(inv);
    }
}
