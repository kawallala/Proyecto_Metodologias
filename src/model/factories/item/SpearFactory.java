package model.factories.item;

import model.items.offensive.physical.Spear;

/**
 * This class represents a Spear creating factory
 */
public class SpearFactory extends AbstractEquipableItemFactory {

  /**
   * Sets the default parameters for the spear to be created with
   */
  @Override
  public void setDefaults() {
    setName("Spear");
    setPower(25);
    setMinimumRange(1);
    setMaximumRange(2);
  }

  /**
   * Creates a new Spear with the parameters stored in the factory
   *
   * @return the newly created Spear
   */
  @Override
  public Spear create() {
    Spear item = new Spear(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    setDefaults();
    return item;
  }
}
