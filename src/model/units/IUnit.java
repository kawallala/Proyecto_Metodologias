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
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IUnit {

//  /**
//   * Sets the currently equipped item of this unit.
//   *
//   * @param item
//   *     the item to equip
//   */
//  void equipItem(IEquipableItem item);

  /**
   * @return hit points of the unit
   */
  int getCurrentHitPoints();

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
   * Equips a Bow to the unit
   * @param bow
   *      the Bow to be equipped
   */
  void equipBow(Bow bow);

  /**
   * Equips a staff to the unit
   * @param staff
   *      the Staff to be equipped
   */

  void equipStaff(Staff staff);
  /**
   * Equips an Axe to the unit
   * @param axe
   *      the Axe to be equipped
   */
  void equipAxe(Axe axe);

  /**
   * Equips an Spear to the unit
   * @param spear
   *      the Spear to be equipped
   */
  void equipSpear(Spear spear);

  /**
   * Equips an Sword to the unit
   * @param sword
   *      the Sword to be equipped
   */
  void equipSword(Sword sword);

  /**
   * Makes this unit attack another unit.
   * <p>
   * If the other unit is outside of this unit's range, the unit does not attack
   */
  void attack(IUnit targetUnit);



}
