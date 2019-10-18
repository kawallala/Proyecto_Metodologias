package model.units;

import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents an <i>Alpaca</i> type unit.
 * <p>
 * This are a special kind of unit that can carry an unlimited amount of items but can't use any of
 * them.
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */

public class Alpaca extends AbstractUnit {

    /**
     * Creates a new Alpaca.
     *
     * @param hitPoints the amount of damage this unit can receive
     * @param movement  number of cells the unit can move
     * @param location  current position of the unit
     * @param items the items that the unit is carrying at the moment of construction
     */
    public Alpaca(final int hitPoints, final int movement, final Location location,
                  final IEquipableItem... items) {
        super(hitPoints, movement, location, Integer.MAX_VALUE, items);
    }

    @Override
    public void addToInventory(IEquipableItem item) {
        if (!this.items.contains(item) && !item.itemInAnInventory()) {
            this.items.add(item);
            item.addedToInventory();
        }
    }

    @Override
    public void beginCombat(IUnit targetUnit) {

    }

    @Override
    public void counterAttack(IUnit targetUnit) {

    }

}
