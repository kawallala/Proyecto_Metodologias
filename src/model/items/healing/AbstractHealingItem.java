package model.items.healing;

import model.items.AbstractItem;
import model.items.offensive.physical.IPhysicalOffensiveItem;
import model.units.IUnit;

/**
 * Abstract class that defines some common behavior for all the healing items
 *
 * @author Martin Araya Zavala
 * @since 1.22
 */
public abstract class AbstractHealingItem extends AbstractItem implements IHealingItem {
    /**
     * Constructor for a Healing Item
     *
     * @param name     the name of the Healing Item
     * @param power    the healing power of the Healing Item
     * @param minRange the minimum range of the Healing Item
     * @param maxRange the maximum range of the Healing Item
     */
    public AbstractHealingItem(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void use(IUnit targetUnit) {
        targetUnit.heal(this.getPower());
    }
}
