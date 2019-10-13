package model.units.factories;

import model.units.IUnit;
import model.units.SwordMaster;

/**
 * This class represents a Sword Master creating factory
 *
 * @author Martin Araya
 * @since 2.4
 */
public class SwordMasterFactory extends AbstractUnitFactory {
    /**
     * Creates a Sword Master with the parameters stored in the factory
     *
     * @return The newly created Sword Master
     */
    @Override
    public IUnit create() {
        return new SwordMaster(this.getHitPoints(), this.getMovement(), this.getLocation());
    }
}
