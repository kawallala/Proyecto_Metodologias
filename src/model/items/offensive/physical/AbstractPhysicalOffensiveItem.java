package model.items.offensive.physical;

import model.items.offensive.AbstractOffensiveItem;
import model.units.IUnit;

/**
 * @author Martin Araya Zavala
 * @since 1.22
 */
public abstract class AbstractPhysicalOffensiveItem extends AbstractOffensiveItem implements IPhysicalOffensiveItem {
    /**
     * Constructor for a Physical Offensive Item
     *
     * @param name     the name of the Physical Offensive Item
     * @param power    the offensive power of the Physical Offensive Item
     * @param minRange the minimum range of the Physical Offensive Item
     * @param maxRange the maximum range of the Physical Offensive Item
     */
    public AbstractPhysicalOffensiveItem(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void use(IUnit targetUnit) {
        targetUnit.attackedByPhysicalOffensiveItem(this);
    }
}
