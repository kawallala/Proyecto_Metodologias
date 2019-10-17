package model.factories.unit;

import model.units.Cleric;

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
    public Cleric create() {
        Cleric cleric =  new Cleric(getHitPoints(), getMovement(), getLocation());
        setDefaults();
        return cleric;
    }
}
