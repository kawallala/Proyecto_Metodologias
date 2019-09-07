package model.items.offensive.magic;

import model.items.offensive.*;
import model.items.offensive.physical.*;
import model.units.IUnit;

/**
 * @author Martin Araya Zavala
 * @since 1.22
 */
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
        unit.equipMagicOffensiveItem(this);
    }

    @Override
    public void use(IUnit targetUnit) {
        targetUnit.attackedByMagicOffensiveItem(this);
    }

    @Override
    public void ownerAttackedByPhysicalOffensiveItem(IPhysicalOffensiveItem physicalOffensiveItem) {
        getOwner().strongDamage(physicalOffensiveItem.getPower());
    }
}
