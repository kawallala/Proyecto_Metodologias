package model.units;

import java.util.List;

import model.items.*;
import model.map.Location;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */
public interface IUnit {

    /**
     * @return hit points of the unit
     */
    int getCurrentHitPoints();

    /**
     * @return the maximum hit point of a unit
     */
    int getMaximumHitPoints();

    /**
     * sets the new hit points of a unit
     */
    void setCurrentHitPoints(int hitPoints);

    /**
     * @return the items carried by this unit
     */
    List<IEquipableItem> getItems();

    /**
     * @return the currently equipped item
     */
    IEquipableItem getEquippedItem();

    /**
     * @return the current location of the unit
     */
    Location getLocation();

    /**
     * Sets a new location for this unit,
     */
    void setLocation(final Location location);

    /**
     * @return the number of cells this unit can move
     */
    int getMovement();

    /**
     * Moves this unit to another location.
     * <p>
     * If the other location is out of this unit's movement range, the unit doesn't move.
     */
    void moveTo(Location targetLocation);

    /**
     * Equips an Axe to the unit
     * @param axe
     *      the Axe to be equipped
     */
    void equipAxe(Axe axe);

    /**
     * Attacks this unit with an Axe
     * @param axe
     *      The axe this unit is being attacked with
     */
    void attackedByAxe(Axe axe);

    /**
     * Equips a Bow to the unit
     * @param bow
     *      the Bow to be equipped
     */
    void equipBow(Bow bow);

    /**
     * Attacks this unit with a Bow
     * @param bow
     *      The bow this unit is being attacked with
     */
    void attackedByBow(Bow bow);

    /**
     * Equips a staff to the unit
     * @param staff
     *      the Staff to be equipped
     */

    void equipStaff(Staff staff);

    /**
     * Equips an Spear to the unit
     * @param spear
     *      the Spear to be equipped
     */
    void equipSpear(Spear spear);

    /**
     * Attacks this unit with a Spear
     * @param spear
     *      The spear this unit is being attacked with
     */
    void attackedBySpear(Spear spear);

    /**
     * Equips an Sword to the unit
     * @param sword
     *      the Sword to be equipped
     */
    void equipSword(Sword sword);

    /**
     * Attacks this unit with a Sword
     * @param sword
     *      The sword this unit is being attacked with
     */
    void attackedBySword(Sword sword);

    /**
     * Makes this unit attack another unit.
     * <p>
     * If the other unit is outside of this unit's range, the unit does not attack
     */
    void attack(IUnit targetUnit);

    /**
     * Deals normal damage to this unit
     * @param damage
     *      The damage being dealt
     */
    void normalDamage(int damage);

    /**
     * Deals strong damage to this unit
     * @param damage
     *      The damage being dealt
     */
    void strongDamage(int damage);

    /**
     * Deals weak damage to this unit
     * @param damage
     *      The damage being dealt
     */
    void weakDamage(int damage);

    /**
     * Adds the item to the inventory of this unit
     * @param item
     *      The item that will be added to the inventory
     */
    void addToInventory(IEquipableItem item);

    /**
     * Makes a counter attack to the target unit
     * @param targetUnit
     *      The unit that the counter attack is directed at
     */
    void counterAttack(IUnit targetUnit);
}
