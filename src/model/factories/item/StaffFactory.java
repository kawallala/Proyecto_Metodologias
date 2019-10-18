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
     * @return the newly created S
     */
    @Override
    public Staff create() {
        return new Staff(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    }
}
