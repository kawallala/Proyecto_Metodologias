package model.items.offensive.physical;

import model.units.IUnit;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak against swords.
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */
public class Axe extends AbstractPhysicalOffensiveItem {

    /**
     * Creates a new Axe item
     *
     * @param name      the name of the Axe
     * @param power     the damage of the Axe
     * @param minRange  the minimum range of the Axe
     * @param maxRange  the maximum range of the Axe
     */
    public Axe(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    /**
     * Equips the Axe to a unit
     *
     * @param unit the unit that will be equipped with the Axe
     */
    @Override
    public void equipTo(IUnit unit) {
        unit.equipAxe(this);
    }

    @Override
    public void ownerAttackedByPhysicalOffensiveItem(IPhysicalOffensiveItem physicalOffensiveItem) {
        physicalOffensiveItem.defendedByAxe(this);
    }

    @Override
    public void defendedByAxe(Axe axe) {
        axe.getOwner().normalDamage(this.getPower());
    }

    @Override
    public void defendedBySpear(Spear spear) {
        spear.getOwner().strongDamage(this.getPower());
    }

    @Override
    public void defendedBySword(Sword sword) {
        sword.getOwner().weakDamage(this.getPower());
    }
}
