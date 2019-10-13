package model.units.factories;

import model.units.Archer;
import model.units.IUnit;

/**
 * This class represents a Archer creating Factory
 *
 * @author Martin Araya Zavala
 * @since 2.4
 */
public class ArcherFactory extends AbstractUnitFactory {
    /**
     * Creates an archer with the stored parameters in the factory
     *
     * @return The newly created Archer
     */
    @Override
    public IUnit create() {
        return new Archer(this.getHitPoints(), this.getMovement(), this.getLocation());
    }
}
