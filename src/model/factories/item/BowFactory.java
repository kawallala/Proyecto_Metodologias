package model.factories.item;

import model.items.offensive.physical.Bow;

/**
 * This class represents a Bow creating Factory
 *
 * @author Martin Araya
 * @since 2.8
 */
public class BowFactory extends AbstractEquipableItemFactory {

  /**
   * Sets the default parameters for the bow to be created with
   */
  @Override
  public void setDefaults() {
    setName("Bow");
    setPower(25);
    setMinimumRange(2);
    setMaximumRange(3);
  }

  /**
   * Sets the minimum range of the bow that will be created, a bow can not have a range less than 2
   *
   * @param minimumRange the minimum range of the bow that will be created
   */
  @Override
  public void setMinimumRange(int minimumRange) {
    super.setMinimumRange(Math.max(minimumRange, 2));
  }

  /**
   * Creates a new bow with the parameters stored in the factory
   *
   * @return The newly created Bow
   */
  @Override
  public Bow create() {
    Bow item = new Bow(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    setDefaults();
    return item;
  }
}
