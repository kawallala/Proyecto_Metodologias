package model.factories.item;

import model.items.healing.Staff;

/**
 * This class represents a staff creating factory
 */
public class StaffFactory extends AbstractEquipableItemFactory {

  /**
   * Sets the defalt parameters for the Staff to be created with
   */
  @Override
  public void setDefaults() {
    setName("Staff");
    setPower(25);
    setMinimumRange(1);
    setMaximumRange(2);
  }

  /**
   * Creates a new Staff with the parameters stored in the factory
   *
   * @return the newly created Staff
   */
  @Override
  public Staff create() {
    Staff item = new Staff(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    setDefaults();
    return item;
  }
}
