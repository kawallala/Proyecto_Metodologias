package model.items.offensive;

import model.items.AbstractItem;
import model.units.IUnit;

/**
 * @author Martin Araya Zavala
 * @since 1.22
 */
public abstract class AbstractOffensiveItem extends AbstractItem implements IOffensiveItem{
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public AbstractOffensiveItem(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }
}
