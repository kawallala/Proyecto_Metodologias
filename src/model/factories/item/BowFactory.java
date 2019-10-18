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

    @Override
    public Bow create() {
        return new Bow(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    }
}
