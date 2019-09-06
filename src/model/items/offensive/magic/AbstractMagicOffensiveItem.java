package model.items.offensive.magic;

import model.items.offensive.*;
import model.units.IUnit;

public abstract class AbstractMagicOffensiveItem extends AbstractOffensiveItem implements IMagicOffensiveItem {
    /**
     * Constructor for a magic book
     *
     * A magic book is strong and weak against non-magic items
     *
     *
     * @param name     the name of the Magic book
     * @param power    the power of the Magic book
     * @param minRange the minimum range of the Magic book
     * @param maxRange the maximum range of the Magic book
     */
    public AbstractMagicOffensiveItem(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipTo(IUnit unit) {
        unit.equipMagicItem(this);
    }

    @Override
    public void use(IUnit targetUnit) {
        targetUnit.attackedByMagicBook(this);
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

    @Override
    public void ownerAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
        getOwner().normalDamage(lightMagicBook.getPower());
    }

    @Override
    public void ownerAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
        getOwner().normalDamage(darkMagicBook.getPower());
    }

    @Override
    public void ownerAttackedByAnimaMagicBook(AnimaMagicBook animaMagicBook) {
        getOwner().normalDamage(animaMagicBook.getPower());
    }
}
