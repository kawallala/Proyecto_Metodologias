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
    //TODO preguntar al aux al respecto
    @Override
    public abstract void equipTo(final IUnit unit);

    @Override
    public abstract void attackWith(IUnit targetUnit);

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
        this.owner.normalDamage(axe.getPower());
    }

    @Override
    public void ownerAttackedByBow(Bow bow) {
        this.owner.normalDamage(bow.getPower());
    }

    @Override
    public void ownerAttackedBySpear(Spear spear) {
        this.owner.normalDamage(spear.getPower());
    }

    @Override
    public void ownerAttackedBySword(Sword sword) {
        this.owner.normalDamage(sword.getPower());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IEquipableItem && ((IEquipableItem) obj).getName() == this.name &&
                ((IEquipableItem) obj).getMinRange() == this.minRange &&
                ((IEquipableItem) obj).getMaxRange() == this.maxRange &&
                ((IEquipableItem) obj).getPower() == this.power){
            return true;
        } else {
            return false;
        }
    }
}
