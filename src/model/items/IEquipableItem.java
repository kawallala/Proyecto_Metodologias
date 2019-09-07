package model.items;

import model.items.offensive.magic.IMagicOffensiveItem;
import model.items.offensive.physical.*;
import model.units.IUnit;

/**
 * This interface represents the <i>Items</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the items are defined here. Every item has a
 * base power.
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */
public interface IEquipableItem {

    /**
     * Equips this item to a unit.
     *
     * @param unit the unit that will be equipped with the item
     */
    void equipTo(IUnit unit);

    /**
     * Sets this item's owner
     *
     * @param unit the unit that has equipped the item
     */
    void setOwner(IUnit unit);

    /**
     * @return the unit that has currently equipped this item
     */
    IUnit getOwner();

    /**
     * @return the name of the item
     */
    String getName();

    /**
     * @return the power of the item
     */
    int getPower();

    /**
     * @return the minimum range of the item
     */
    int getMinRange();

    /**
     * @return the maximum range of the item
     */
    int getMaxRange();

    /**
     * Uses the item on a target unit
     *
     * @param targetUnit the unit that the item is being used on
     */
    void use(IUnit targetUnit);

    /**
     * Deals normal damage to the owner of the item
     *
     * @param physicalOffensiveItem the physical offensive item that is dealing the damage
     */
    void ownerAttackedByOffensiveItem(IPhysicalOffensiveItem physicalOffensiveItem);

    /**
     * Deals normal damage to the owner of the item
     *
     * @param magicOffensiveItem the magic offensive item that is dealing the damage
     */
    void ownerAttackedByOffensiveMagicItem(IMagicOffensiveItem magicOffensiveItem);

    /**
     * Deals normal damage to the owner of the item
     *
     * @param axe the axe that is dealing the damage
     */
    void ownerAttackedByAxe(Axe axe);

    /**
     * Deals normal damage to the owner of the item
     *
     * @param bow the bow that is dealing the damage
     */
    void ownerAttackedByBow(Bow bow);

    /**
     * Deals normal damage to the owner of the item
     *
     * @param spear the spear that is dealing the damage
     */
    void ownerAttackedBySpear(Spear spear);
    /**
     * Deals normal damage to the owner of the item
     *
     * @param sword the sword that is dealing the damage
     */
    void ownerAttackedBySword(Sword sword);

    /**
     * Deals strong damage to the owner of the item
     *
     * @param magicOffensiveItem the magic book that is dealing the damage
     */
    void ownerAttackedByMagicOffensiveItem(IMagicOffensiveItem magicOffensiveItem);

    /**
     * Defines the type of damage the owner of the item will receive
     * @param physicalOffensiveItem the physical offensive item that is dealing the damage
     */
    void ownerAttackedByPhysicalOffensiveItem(IPhysicalOffensiveItem physicalOffensiveItem);
}
