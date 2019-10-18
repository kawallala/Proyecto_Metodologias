package model.factories.item;

import model.items.IEquipableItem;
import model.items.offensive.physical.Axe;

public class AxeFactory extends AbstractEquipableItemFactory {

    @Override
    public void setDefaults(){
        setName("Axe");
        setPower(25);
        setMinimumRange(1);
        setMaximumRange(2);
    }

    @Override
    public Axe create() {
        return new Axe(this.getName(),this.getPower(),this.getMinimumRange(),this.getMaximumRange());
    }
}
