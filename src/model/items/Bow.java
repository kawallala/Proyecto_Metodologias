package model.items;

import model.units.IUnit;

/**
 * @author Martin Araya Zavala
 * @since 1.0
 */
public class Bow extends AbstractItem {

    private IUnit unit;

    /**
     * Creates a new Bow.
     * <p>
     * Bows are weapons that can't attack adjacent units, so it's minimum range must me greater than
     * one.
     *
     * @param name      the name of the Bow
     * @param power     the damage power of the Bow
     * @param minRange  the minimum range of the Bow
     * @param maxRange  the maximum range of the Bow
     */
    public Bow(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
        this.minRange = Math.max(minRange, 2);
        this.maxRange = Math.max(maxRange, this.minRange);
    }

    /**
     * Equips the Bow to the unit
     *
     * @param unit the unit that will be equipped with the Bow
     */
    @Override
    public void equipTo(IUnit unit) {
        unit.equipBow(this);
    }

    /**
     * Attacks the target unit with this bow
     *
     * @param targetUnit the unit being attacked
     */
    @Override
    public void attackWith(IUnit targetUnit) {
        targetUnit.attackedByBow(this);
    }
}
