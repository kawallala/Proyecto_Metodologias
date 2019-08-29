package model.items;

import model.units.IUnit;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */
public interface IEquipableItem {

    /**
     * Equips this item to a unit.
     *
     * @param unit
     *     the unit that will be quipped with the item
     */
    void equipTo(IUnit unit);

    /**
     * Sets this item's owner
     *
     * @param unit
     *     The unit that has equipped the item
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
     * Makes an attack with the item
     * @param targetUnit the unit being attacked
     */
    void attackWith(IUnit targetUnit);

    /**
     * Calculates the type of damage to the owner of this item
     * @param axe
     *      The axe that is dealing the damage
     */
    void ownerAttackedByAxe(Axe axe);

    /**
     * Calculates the type of damage to the owner of this item
     * @param bow
     *      The bow that is dealing the damage
     */
    void ownerAttackedByBow(Bow bow);

    /**
     * Calculates the type of damage to the owner of this item
     * @param spear
     *      The spear that is dealing the damage
     */
    void ownerAttackedBySpear(Spear spear);
    /**
     * Calculates the type of damage to the owner of this item
     * @param sword
     *      The sword that is dealing the damage
     */
    void ownerAttackedBySword(Sword sword);
}
