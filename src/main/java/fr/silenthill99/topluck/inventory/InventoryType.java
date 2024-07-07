package fr.silenthill99.topluck.inventory;

import fr.silenthill99.topluck.inventory.hook.modo.ChoosePlayerInventory;
import fr.silenthill99.topluck.inventory.hook.modo.InvSeeInventory;
import fr.silenthill99.topluck.inventory.hook.modo.TopLuckInventory;

import java.util.Arrays;
import java.util.List;

public enum InventoryType {
    CHOOSE(new ChoosePlayerInventory()),
    INVSEE(new InvSeeInventory()),
    TOPLUCK(new TopLuckInventory())
    ;
    private final AbstractInventory<?> inv;

    InventoryType(AbstractInventory<?> inv) {
        this.inv = inv;
    }

    public AbstractInventory<?> getInv() {
        return inv;
    }

    public static List<InventoryType> toArrayList() {
        return Arrays.asList(values());
    }
}
