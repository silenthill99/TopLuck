package fr.silenthill99.topluck.inventory;

import fr.silenthill99.topluck.commands.TopLuck;
import fr.silenthill99.topluck.inventory.hook.modo.PlayerChooseInventory;
import fr.silenthill99.topluck.inventory.hook.modo.TopLuckInventory;

public enum InventoryType
{
    PLAYER_CHOOSE(new PlayerChooseInventory()),
    TOPLUCK(new TopLuckInventory())
    ;
    private final AbstractInventory<?> inv;

    InventoryType(AbstractInventory<?> inv)
    {
        this.inv = inv;
    }

    public AbstractInventory<?> getInv()
    {
        return this.inv;
    }
}
