package model.items.offensive;

import model.items.AbstractItem;
import model.units.IUnit;

/**
 * This class represents a sword type item.
 * <p>
 * Swords are strong against axes and weak against spears.
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */
public class Sword extends AbstractOffensiveItem {

    /**
     * Creates a new Sword.
     *
     * @param name the name that identifies the Sword
     * @param power the base damage pf the Sword
     * @param minRange the minimum range of the Sword
     * @param maxRange the maximum range of the Sword
     */
    public Sword(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    /**
     * Equips the Sword to the unit
     *
     * @param unit the unit that will be equipped with the Sword
     */
    @Override
    public void equipTo(IUnit unit) {
        unit.equipSword(this);
    }

    /**
     * Attacks the target unit with the Sword
     *
     * @param targetUnit the unit being attacked
     */
    @Override
    public void use(IUnit targetUnit) {
        targetUnit.attackedBySword(this);
    }

    /**
     * Deals weak damage to the owner of the Sword, since the Sword is strong against axes
     *
     * @param axe the Axe that is dealing the damage
     */
    @Override
    public void ownerAttackedByAxe(Axe axe) {
        getOwner().weakDamage(axe.getPower());
    }

    /**
     * Deals strong damage to the owner of the Sword, since the Sword is weak against spears
     *
     * @param spear the Spear that is dealing the damage
     */
    @Override
    public void ownerAttackedBySpear(Spear spear) {
        getOwner().strongDamage(spear.getPower());
    }
}
