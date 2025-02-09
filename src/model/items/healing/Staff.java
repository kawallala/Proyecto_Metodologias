package model.items.healing;

import model.units.IUnit;

/**
 * This class represents a <i>Staff</i> type item.
 * <p>
 * A staff is an item that can heal other units and cannot attack or counter attack
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */
public class Staff extends AbstractHealingItem {

    /**
     * Creates a new Staff item.
     *
     * @param name     the name of the staff
     * @param power    the healing power of the staff
     * @param minRange the minimum range of the staff
     * @param maxRange the maximum range of the staff
     */
    public Staff(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    /**
     * Equips this Staff to the unit
     *
     * @param unit the unit that will be equipped with the item
     */
    @Override
    public void equipTo(IUnit unit) {
        unit.equipStaff(this);
    }
}
