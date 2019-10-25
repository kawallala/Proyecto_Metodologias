package model.units;

import model.items.IEquipableItem;
import model.items.offensive.physical.Spear;
import model.map.Location;

/**
 * A <i>Hero</i> is a special kind of unit, the player that defeats this unit wins the game.
 * <p>
 * This unit <b>can only use spear weapons</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Hero extends AbstractUnit {

    /**
     * Creates a new Unit.
     *
     * @param hitPoints
     *     the maximum amount of damage a unit can sustain
     * @param movement
     *     the number of panels a unit can move
     */
    public Hero(final int hitPoints, final int movement, final Location location,
                IEquipableItem... items) {
        super(hitPoints, movement, location, 3, items);
    }

    /**
     * Sets the currently equipped item of this unit.
     * <p>
     * The <i>Hero</i> can <b>only equip Spears</b>.
     *
     * @param spear
     *     the spear to equip
     */
    @Override
    public void equipSpear(Spear spear){
        if(this.items.contains(spear)) {
            this.equippedItem = spear;
            spear.setOwner(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && obj instanceof Hero;
    }

}
