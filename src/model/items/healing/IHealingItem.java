package model.items.healing;

import model.items.IEquipableItem;
import model.units.IUnit;

/**
 * This interface represents the <i>Healing items</i> that the units of the game can use
 * <p>
 * The signature for all the common methods of Healing Items is found here
 * All healing items use their base power to heal
 *
 * @author Martin Araya Zavala
 * @since 1.22
 */
public interface IHealingItem extends IEquipableItem {
    /**
     * Heals with the healing item
     *
     * @param targetUnit the unit that the owner of the item is healing
     */
    @Override
    void use(IUnit targetUnit);
}
