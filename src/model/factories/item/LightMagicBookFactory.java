package model.factories.item;

import model.items.offensive.magic.LightMagicBook;

/**
 * This class represents a Light Magic Book creating factory
 *
 * @author Martin Araya
 * @since 2.8
 */
public class LightMagicBookFactory extends AbstractEquipableItemFactory {

    /**
     * Sets the default parameters for the Light Magic Book
     */
    @Override
    public void setDefaults() {
        setName("Light Magic Book");
        setPower(25);
        setMinimumRange(1);
        setMaximumRange(2);
    }

    /**
     * Creates a new Light Magic Book with the parameters stored in the factory
     *
     * @return the newly created Light Magic Book
     */
    @Override
    public LightMagicBook create() {
        return new LightMagicBook(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    }
}
