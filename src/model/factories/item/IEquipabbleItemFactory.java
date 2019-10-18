package model.factories.item;

import model.items.IEquipableItem;

public interface IEquipabbleItemFactory {
    IEquipableItem create();
    void setDefaults();
    void setName(String name);
    void setPower(int power);
    void setMinimumRange(int minimumRange);
    void setMaximumRange(int maximumRange);
}
