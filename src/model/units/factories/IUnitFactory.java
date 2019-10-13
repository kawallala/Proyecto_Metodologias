package model.units.factories;

import model.map.Location;
import model.units.IUnit;

/**
 * This interface represents all the unit creating factories of the game
 *
 * There is a default value for all the parameters a unit can have, and a user can set different parameters to
 * the unit that will be created
 *
 * @author Martin Araya
 * @since 2.4
 */
public interface IUnitFactory {
    /**
     * Creates a unit with the parameters stored in the factory
     *
     * @return The created unit
     */
    IUnit create();

    /**
     * Sets a new location for the unit to be created in
     *
     * @param location the location the unit will be created in
     */
    void setLocation(Location location);

    /**
     * Sets a new amount of hitpoints for the unit to be created
     *
     * @param hitPoints the amount of hitpoints the created unit will have
     */
    void setHitPoints(int hitPoints);

    /**
     * Sets a new amount of cells to move for the created unit
     *
     * @param movement the amount of cells the crated unit will move
     */
    void setMovement(int movement);
}
