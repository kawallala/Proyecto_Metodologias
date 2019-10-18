package model.factories.item;

import model.items.offensive.physical.Bow;
import model.items.offensive.physical.Spear;

public class StaffFactory extends AbstractEquipableItemFactory {

    @Override
    public void setDefaults(){
        setName("Staff");
        setPower(25);
        setMinimumRange(1);
        setMaximumRange(2);
    }

    @Override
    public Spear create() {
        return new Spear(this.getName(),this.getPower(),this.getMinimumRange(),this.getMaximumRange());
    }
}
