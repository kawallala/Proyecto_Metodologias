package model.factories.item;

import model.items.offensive.physical.Axe;

/**
 * This class represents an Axe creating Factory
 *
 * @author Martin Araya
 * @since 2.8
 */
public class AxeFactory extends AbstractEquipableItemFactory {

    /**
     * Sets the default parameters for the axe to be created with
     */
    @Override
    public void setDefaults() {
        setName("Axe");
        setPower(25);
        setMinimumRange(1);
        setMaximumRange(2);
    }

    /**
     * Creates a new Axe with the parameters stored in the class
     *
     * @return the newly created Axe
     */
    @Override
    public Axe create() {
        return new Axe(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    }
}
