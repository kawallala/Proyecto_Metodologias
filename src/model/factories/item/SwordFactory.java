package model.factories.item;

import model.items.offensive.physical.Sword;

/**
 * This class represents a Sword creating factory
 */
public class SwordFactory extends AbstractEquipableItemFactory {

    /**
     * Sets the default parameters for the Sword to be created with
     */
    @Override
    public void setDefaults() {
        setName("Sword");
        setPower(25);
        setMinimumRange(1);
        setMaximumRange(2);
    }

    /**
     * Creates a new Sword with the parameters stored in the factory
     * @return the newly created Sword
     */
    @Override
    public Sword create() {
        return new Sword(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    }
}
