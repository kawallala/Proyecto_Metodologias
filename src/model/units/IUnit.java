package model.units;

import java.util.List;

import model.items.*;
import model.items.healing.Staff;
import model.items.offensive.magic.IMagicOffensiveItem;
import model.items.offensive.magic.AbstractMagicOffensiveItem;
import model.items.offensive.physical.*;
import model.map.Location;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute is defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * No item can be equipped to a default unit
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
     * @return the items carried by this unit
     */
    List<IEquipableItem> getItems();

    /**
     * @return the maximum number of items that this unit can equip
     */
    int getMaximumItems();
    /**
     * @return the currently equipped item
     */
    IEquipableItem getEquippedItem();

    /**
     * @return the number of cells this unit can move
     */
    int getMovement();

    /**
     * @return the current location of the unit
     */
    Location getLocation();

    /**
     * Sets a new location for this unit
     */
    void setLocation(final Location location);

    /**
     * Moves this unit to another location.
     * <p>
     * If the other location is out of this unit's movement range, the unit doesn't move.
     */
    void moveTo(Location targetLocation);

    /**
     * Equips an item to this unit
     * @param item
     *      The item that is being equipped
     */
    void equip(IEquipableItem item);

    /**
     * Unequips current equipped item, if there is one
     */
    void unequip();

    /**
     * Tries to equip an Axe to the unit, by default does nothing
     * @param axe
     *      the Axe to be equipped
     */
    void equipAxe(Axe axe);

    /**
     * Tries to equips a Bow to the unit, by default does nothing
     * @param bow
     *      the Bow to be equipped
     */
    void equipBow(Bow bow);

    /**
     * Tries to equip a staff to the unit, by default it does nothing
     * @param staff
     *      the Staff to be equipped
     */

    void equipStaff(Staff staff);

    /**
     * Tries to equip an Spear to the unit, by default it does nothing
     * @param spear
     *      the Spear to be equipped
     */
    void equipSpear(Spear spear);

    /**
     * Tries to equip an Sword to the unit, by default it does nothing
     * @param sword
     *      the Sword to be equipped
     */
    void equipSword(Sword sword);

    /**
     * Tries to equip a Magic Book to the unit, by default it does nothing
     * @param magicOffensiveItem
     *      the Magic Book to be equipped
     */
    void equipMagicOffensiveItem(AbstractMagicOffensiveItem magicOffensiveItem);

    /**
     * Attacks the unit with a Offensive Item
     *
     * @param physicalOffensiveItem the offensive item the unit is being attacked with
     */
    void attackedByPhysicalOffensiveItem(IPhysicalOffensiveItem physicalOffensiveItem);

    /**
     * Attacks this unit with a magic book
     * @param magicOffensiveItem
     *      The magic book this unit is being attacked with
     */
    void attackedByMagicOffensiveItem(IMagicOffensiveItem magicOffensiveItem);

    /**
     * Makes this unit attack another unit.
     * <p>
     * If the other unit is outside of this unit's range, the unit does not attack
     */
    void attack(IUnit targetUnit);

    /**
     * Makes a counter attack to the target unit
     * @param targetUnit
     *      The unit that the counter attack is directed at
     */
    void counterAttack(IUnit targetUnit);

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
     * Removes the item from the inventory of this unit
     * @param item
     *      The item to be removed
     */
    void removeFromInventory(IEquipableItem item);

    /**
     * Gives an item belonging in the inventory to a receiving unit
     * @param item
     *      The item that is being given to the receiving unit
     */
    void giveItem(IEquipableItem item, IUnit receivingUnit);

    /**
     * Heals the unit using a healing item
     *
     * @param healingPower The power of the item that is healing the unit
     */
    void heal(int healingPower);
}
