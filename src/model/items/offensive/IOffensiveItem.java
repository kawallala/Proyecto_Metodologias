package model.items.offensive;

import model.items.IEquipableItem;

/**
 * Tis interface represents the <i>Offensive Items</i> that the units of the game can use
 * <p>
 *  The signature for all the common methods of Offensive Items are defined here.
 *  Every offense item has a base power and is strong or weak against other type of offensive items.
 *  All non-magic offensive items are weak against magic items
 *
 * @author Martin Araya Zavala
 * @since 1.21
 */
public interface IOffensiveItem extends IEquipableItem {
}
