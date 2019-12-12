package model.factories.item;

import model.items.IEquipableItem;

/**
 * This interface represents all the item crating factories of the game
 * <p>
 * There is a default value for all the parameters an item can have, and a user can set different parameters to
 * the item that will be created
 *
 * @author MArtin Araya
 * @since 2.8
 */

public interface IEquipableItemFactory {
  /**
   * Creates an item with the parameters stored in the factory
   *
   * @return The created item
   */
  IEquipableItem create();

  /**
   * Sets the default parameters for the item to be created with
   */
  void setDefaults();

  /**
   * Sets a new name for the item
   *
   * @param name the name of the item that will be created
   */
  void setName(String name);

  /**
   * Sets the power for the item that will be created
   *
   * @param power the power of the item that will be created
   */
  void setPower(int power);

  /**
   * Sets the minimum range of the item that will be created
   * If the new minimum is greater than the previous maximum, the maximum gets changed too
   *
   * @param minimumRange the minimum range of the item that will be created
   */
  void setMinimumRange(int minimumRange);

  /**
   * Sets the maximum range of the item that will be created, the maximum range can not be less than the minimum range
   *
   * @param maximumRange the maximum range of the item that will be created
   */
  void setMaximumRange(int maximumRange);
}
