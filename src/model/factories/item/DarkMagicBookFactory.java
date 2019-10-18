package model.factories.item;

import model.items.offensive.magic.DarkMagicBook;

public class DarkMagicBookFactory extends AbstractEquipableItemFactory {

    @Override
    public void setDefaults() {
        setName("Dark Magic Book");
        setPower(25);
        setMinimumRange(1);
        setMaximumRange(2);
    }

    @Override
    public DarkMagicBook create() {
        return new DarkMagicBook(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    }
}
