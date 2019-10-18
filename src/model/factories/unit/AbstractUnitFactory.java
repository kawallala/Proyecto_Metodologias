package model.factories.unit;

import model.map.Location;

/**
 * This class represents the abstract behaviour for a unit creating factory
 * <p>
 * There is a default value for all the parameters a unit can be created with, this parameters can be changed for
 * personalization
 *
 * @author Martin Araya
 * @since 2.4
 */
public abstract class AbstractUnitFactory implements IUnitFactory {
    private Location location;
    private int hitPoints;
    private int movement;

    /**
     * Creates a Unit Factory with the default values
     */
    public AbstractUnitFactory() {
        setDefaults();
    }

    public void setDefaults(){
        this.location = new Location(0,0);
        this.hitPoints = 100;
        this.movement = 2;
    }

    /**
     * Getter for the location stored in the factory
     *
     * @return The stored location
     */
    Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Getter for the hitpoints stored in the factory
     *
     * @return th stored hitpoints
     */
    int getHitPoints() {
        return hitPoints;
    }

    @Override
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * Getter for the movement stored in the factory
     *
     * @return the stored movement
     */
    int getMovement() {
        return movement;
    }

    @Override
    public void setMovement(int movement) {
        this.movement = movement;
    }
}
