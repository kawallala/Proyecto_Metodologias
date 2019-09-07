package model.items.healing;

import model.items.AbstractItem;
import model.items.offensive.physical.IPhysicalOffensiveItem;
import model.units.IUnit;

/**
 * @author Martin Araya Zavala
 * @since 1.22
 */
public abstract class AbstractHealingItem extends AbstractItem implements IHealingItem {
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public AbstractHealingItem(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void ownerAttackedByPhysicalOffensiveItem(IPhysicalOffensiveItem physicalOffensiveItem) {
        getOwner().normalDamage(physicalOffensiveItem.getPower());
    }
}
