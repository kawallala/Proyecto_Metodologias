package model.units;

import model.items.IEquipableItem;
import model.items.MagicBook;
import model.map.Location;

/**
 * This class represents an <i>Alpaca</i> type unit.
 * A sorcerer is a unit that can only equip magic books
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */
public class Sorcerer extends AbstractUnit {
    /**
     * Creates a new Sorcerer.
     *
     * @param hitPoints the maximum amount of damage a unit can sustain
     * @param movement  the number of panels a unit can move
     * @param location  the current position of this unit on the map
     * @param items the items that the unit is carrying at the moment of construction
     */
    protected Sorcerer(int hitPoints, int movement, Location location, IEquipableItem... items) {
        super(hitPoints, movement, location, 3, items);
    }

    @Override
    public void equipMagicBook(MagicBook magicBook) {
        if(items.contains(magicBook)){
            equippedItem = magicBook;
            magicBook.setOwner(this);
        }
    }
}
