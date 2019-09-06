package model.items.offensive;

import model.items.AbstractItem;
import model.units.IUnit;

/**
 * This class represents a <i>Spear</i>.
 * <p>
 * Spears are strong against swords and weak against axes
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */
public class Spear extends AbstractOffensiveItem {

    /**
     * Creates a new Spear item
     *
     * @param name the name of the Spear
     * @param power the damage of the Spear
     * @param minRange the minimum range of the Spear
     * @param maxRange the maximum range of the Spear
     */
    public Spear(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    /**
     * Equips the spear to the unit
     *
     * @param unit the unit that will be equipped with this Spear
     */
    @Override
    public void equipTo(IUnit unit) {
        unit.equipSpear(this);
    }

    /**
     * Attacks the target unit with the Spear
     *
     * @param targetUnit the unit being attacked
     */
    @Override
    public void use(IUnit targetUnit) {
        targetUnit.attackedBySpear(this);
    }

    /**
     * Deals strong damage to the owner of the Spear, since the Spear is weak against axes
     *
     * @param axe The axe that is dealing the damage
     */
    @Override
    public void ownerAttackedByAxe(Axe axe) {
        getOwner().strongDamage(axe.getPower());
    }

    /**
     * Deals weak damage to the owner of the Spear, since the Spear is strong agains Swords
     *
     * @param sword the Sword that is dealing the damage
     */
    @Override
    public void ownerAttackedBySword(Sword sword) {
        getOwner().weakDamage(sword.getPower());
    }
}
