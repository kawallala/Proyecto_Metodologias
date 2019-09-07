package model.items.offensive.physical;

import model.items.offensive.AbstractOffensiveItem;
import model.units.IUnit;

/**
 * @author Martin Araya Zavala
 * @since 1.22
 */
public abstract class AbstractPhysicalOffensiveItem extends AbstractOffensiveItem implements IPhysicalOffensiveItem {
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public AbstractPhysicalOffensiveItem(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void use(IUnit targetUnit) {
        targetUnit.attackedByPhysicalOffensiveItem(this);
    }
}
