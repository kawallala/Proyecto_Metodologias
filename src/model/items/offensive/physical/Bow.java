package model.items.offensive.physical;

import model.units.IUnit;

/**
 * This class represents a <i>Bow</i>
 * Bows are neither strong or weak aginst any item
 * @author Martin Araya Zavala
 * @since 1.0
 */
public class Bow extends AbstractPhysicalOffensiveItem {

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

    @Override
    public void defendedByAxe(Axe axe) {
        axe.getOwner().normalDamage(this.getPower());
    }

    @Override
    public void defendedBySpear(Spear spear) {
        spear.getOwner().normalDamage(this.getPower());
    }

    @Override
    public void defendedBySword(Sword sword) {
        sword.getOwner().normalDamage(this.getPower());
    }
}
