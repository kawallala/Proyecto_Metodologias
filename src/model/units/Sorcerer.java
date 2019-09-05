package model.units;

import model.items.IEquipableItem;
import model.items.MagicBook;
import model.map.Location;

public class Sorcerer extends AbstractUnit {
    /**
     * Creates a new Unit.
     *
     * @param hitPoints the maximum amount of damage a unit can sustain
     * @param movement  the number of panels a unit can move
     * @param location  the current position of this unit on the map
     * @param maxItems  maximum amount of items this unit can carry
     * @param items
     */
    protected Sorcerer(int hitPoints, int movement, Location location, int maxItems, IEquipableItem... items) {
        super(hitPoints, movement, location, maxItems, items);
    }

    @Override
    public void equipMagicBook(MagicBook magicBook) {
        if(items.contains(magicBook)){
            equippedItem = magicBook;
            magicBook.setOwner(this);
        }
    }
}
