package model.items;

import model.units.IUnit;

public abstract class MagicBook extends AbstractItem {
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public MagicBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipTo(IUnit unit) {
        unit.equipMagicBook(this);
    }

    @Override
    public void ownerAttackedByAxe(Axe axe) {
        getOwner().strongDamage(axe.getPower());
    }

    @Override
    public void ownerAttackedByBow(Bow bow) {
        getOwner().strongDamage(bow.getPower());
    }

    @Override
    public void ownerAttackedBySpear(Spear spear) {
        getOwner().strongDamage(spear.getPower());
    }

    @Override
    public void ownerAttackedBySword(Sword sword) {
        getOwner().strongDamage(sword.getPower());
    }
}
