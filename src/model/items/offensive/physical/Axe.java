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

    /**
     * Deals weak damage to the owner of the axe, since the Axe is strong against spears
     * @param spear
     *      The Spear that is doing the damage
     */
    @Override
    public void ownerAttackedBySpear(Spear spear) {
        getOwner().weakDamage(spear.getPower());
    }

    /**
     * Deals strong damage to the owner of the Axe, since the Axe is weak against Swords
     * @param sword
     *      The Sword that is dealing the damage
     */
    @Override
    public void ownerAttackedBySword(Sword sword) {
        getOwner().strongDamage(sword.getPower());
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
