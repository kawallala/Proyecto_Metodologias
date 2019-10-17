package model.factories.unit;

import model.units.Archer;

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
    public Archer create() {
        Archer archer =  new Archer(getHitPoints(), getMovement(), getLocation());
        setDefaults();
        return archer;
    }
}
