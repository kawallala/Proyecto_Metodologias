package model.factories.item;

import model.items.IEquipableItem;
import model.items.offensive.physical.Axe;
import model.items.offensive.physical.Bow;

public class BowFactory extends AbstractEquipableItemFactory {

    @Override
    public void setDefaults(){
        setName("Bow");
        setPower(25);
        setMinimumRange(2);
        setMaximumRange(3);
    }

    @Override
    public Bow create() {
        return new Bow(this.getName(),this.getPower(),this.getMinimumRange(),this.getMaximumRange());
    }
}
