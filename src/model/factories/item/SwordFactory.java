package model.factories.item;

import model.items.offensive.physical.Spear;
import model.items.offensive.physical.Sword;

public class SwordFactory extends AbstractEquipableItemFactory {

    @Override
    public void setDefaults(){
        setName("Sword");
        setPower(25);
        setMinimumRange(1);
        setMaximumRange(2);
    }

    @Override
    public Sword create() {
        return new Sword(this.getName(),this.getPower(),this.getMinimumRange(),this.getMaximumRange());
    }
}
