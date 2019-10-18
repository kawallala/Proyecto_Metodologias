package model.factories.item;

import model.items.offensive.magic.AnimaMagicBook;

public class AnimaMagicBookFactory extends AbstractEquipableItemFactory {

    @Override
    public void setDefaults() {
        setName("Anima Magic Book");
        setPower(25);
        setMinimumRange(1);
        setMaximumRange(2);
    }

    @Override
    public AnimaMagicBook create() {
        return new AnimaMagicBook(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    }
}
