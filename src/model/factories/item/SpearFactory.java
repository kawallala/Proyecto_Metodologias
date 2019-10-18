package model.factories.item;

import model.items.healing.Staff;
import model.items.offensive.physical.Bow;

public class SpearFactory extends AbstractEquipableItemFactory {

    @Override
    public void setDefaults(){
        setName("Spear");
        setPower(25);
        setMinimumRange(1);
        setMaximumRange(2);
    }

    @Override
    public Staff create() {
        return new Staff(this.getName(),this.getPower(),this.getMinimumRange(),this.getMaximumRange());
    }
}
