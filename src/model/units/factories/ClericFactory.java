package model.units.factories;

import model.units.Cleric;
import model.units.IUnit;

/**
 * This class represents a cleric creating factory
 *
 * @author Martin Araya
 * @since 2.4
 */
public class ClericFactory extends AbstractUnitFactory {
    /**
     * Creates a new Cleric with the stored parameters in the factory
     *
     * @return THe newly created Cleric
     */
    @Override
    public IUnit create() {
        return new Cleric(this.getHitPoints(), this.getMovement(), this.getLocation());
    }
}
