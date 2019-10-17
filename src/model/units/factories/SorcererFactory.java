package model.units.factories;

import model.units.IUnit;
import model.units.Sorcerer;

/**
 * This class represents a Sorcerer creating factory
 *
 * @author Martin Araya
 * @since 2.4
 */
public class SorcererFactory extends AbstractUnitFactory {
    /**
     * Creates a Sorcerer with the parameters stored in the factory
     *
     * @return The newly created Sorcerer
     */
    @Override
    public Sorcerer create() {
        Sorcerer sorcerer = new Sorcerer(this.getHitPoints(), this.getMovement(), this.getLocation());
        this.setDefaults();
        return sorcerer;
    }
}
