package model.items.offensive.physical;

import model.items.offensive.AbstractOffensiveItem;
import model.units.IUnit;

/**
 * This class represents a <i>Spear</i>.
 * <p>
 * Spears are strong against swords and weak against axes
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */
public class Spear extends AbstractPhysicalOffensiveItem {

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
    @Override
    public void ownerAttackedByPhysicalOffensiveItem(IPhysicalOffensiveItem physicalOffensiveItem) {
        physicalOffensiveItem.defendedBySpear(this);
    }

    @Override
    public void defendedByAxe(Axe axe) {
        axe.getOwner().weakDamage(this.getPower());
    }

    @Override
    public void defendedBySpear(Spear spear) {
        spear.getOwner().normalDamage(this.getPower());
    }

    @Override
    public void defendedBySword(Sword sword) {
        sword.getOwner().strongDamage(this.getPower());
    }
}
