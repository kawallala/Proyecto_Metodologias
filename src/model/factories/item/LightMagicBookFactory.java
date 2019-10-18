package model.factories.item;

import model.items.offensive.magic.LightMagicBook;

public class LightMagicBookFactory extends AbstractEquipableItemFactory {

    @Override
    public void setDefaults() {
        setName("Light Magic Book");
        setPower(25);
        setMinimumRange(1);
        setMaximumRange(2);
    }

    @Override
    public LightMagicBook create() {
        return new LightMagicBook(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    }
}
