package model.factories.item;

import model.items.offensive.magic.DarkMagicBook;

/**
 * This class represents  a Dark Magic Book creating factory
 */
public class DarkMagicBookFactory extends AbstractEquipableItemFactory {

    /**
     * Sets the default parameters for the Dark Magic Book to be created with
     */
    @Override
    public void setDefaults() {
        setName("Dark Magic Book");
        setPower(25);
        setMinimumRange(1);
        setMaximumRange(2);
    }

    /**
     * Creates a new Dark Magic Book with the parameters stored in the factory
     *
     * @return the newly created Dark Magic Book
     */
    @Override
    public DarkMagicBook create() {
        return new DarkMagicBook(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    }
}
