package model.items.offensive;

import model.items.IEquipableItem;
import model.units.IUnit;

/**
 * This interface represents the <i>Offensive Items</i> that the units of the game can use
 * <p>
 *  The signature for all the common methods of Offensive Items is defined here.
 *  Every Offensive item has a base power and is strong or weak against other type of offensive items.
 *
 * @author Martin Araya Zavala
 * @since 1.21
 */
public interface IOffensiveItem extends IEquipableItem {
    /**
     * Attacks with the item
     *
     * @param targetUnit the unit that the user of the item is attacking
     */
    @Override
    void use(IUnit targetUnit);
}
