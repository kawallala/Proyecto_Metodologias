package model.items;

import model.units.IUnit;

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
    //TODO cambiar owner por equipped to y generar in inventory
    private IUnit owner;

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
    }

    @Override
    public void setOwner(IUnit unit) {
        owner = unit;
    }

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
    public void ownerAttackedByAxe(Axe axe) {
        owner.normalDamage(axe.getPower());
    }

    @Override
    public void ownerAttackedByBow(Bow bow) {
        owner.normalDamage(bow.getPower());
    }

    @Override
    public void ownerAttackedBySpear(Spear spear) {
        owner.normalDamage(spear.getPower());
    }

    @Override
    public void ownerAttackedBySword(Sword sword) {
        owner.normalDamage(sword.getPower());
    }

    @Override
    public void ownerAttackedByMagicBook(IMagicBook magicBook) {
        owner.strongDamage(magicBook.getPower());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IEquipableItem && ((IEquipableItem) obj).getName().equals(name) &&
                ((IEquipableItem) obj).getMinRange() == minRange &&
                ((IEquipableItem) obj).getMaxRange() == maxRange &&
                ((IEquipableItem) obj).getPower() == power;
    }
}
