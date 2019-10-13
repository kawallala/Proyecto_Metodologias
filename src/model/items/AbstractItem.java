package model.items;

import model.items.offensive.magic.IMagicOffensiveItem;
import model.items.offensive.physical.*;
import model.units.IUnit;

import javax.xml.stream.FactoryConfigurationError;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {
    private final String name;
    private final int power;
    protected int maxRange;
    protected int minRange;
    private IUnit owner;
    private boolean inInventory;

    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public AbstractItem(final String name, final int power, final int minRange, final int maxRange) {
        this.name = name;
        this.power = power;
        this.minRange = Math.max(minRange, 1);
        this.maxRange = Math.max(maxRange, this.minRange);
        inInventory = false;
    }

    @Override
    public void setOwner(IUnit unit) {
        owner = unit;
    }

    @Override
    public boolean itemInAnInventory() {
        return this.inInventory;
    }

    public void addedToInventory(){inInventory = true;}

    public void removedFromInventory(){inInventory = false;}

    @Override
    public IUnit getOwner() {
        return owner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public int getMinRange() {
        return minRange;
    }

    @Override
    public int getMaxRange() {
        return maxRange;
    }

    @Override
    public void ownerAttackedByPhysicalOffensiveItem(IPhysicalOffensiveItem physicalOffensiveItem) {
        owner.normalDamage(physicalOffensiveItem.getPower());
    }

    @Override
    public void ownerAttackedByMagicOffensiveItem(IMagicOffensiveItem magicOffensiveItem) {
        owner.strongDamage(magicOffensiveItem.getPower());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IEquipableItem && ((IEquipableItem) obj).getName().equals(name) &&
                ((IEquipableItem) obj).getMinRange() == minRange &&
                ((IEquipableItem) obj).getMaxRange() == maxRange &&
                ((IEquipableItem) obj).getPower() == power;
    }
}
