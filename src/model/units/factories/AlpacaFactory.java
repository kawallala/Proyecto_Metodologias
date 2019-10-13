package model.units.factories;

import model.units.Alpaca;
import model.units.IUnit;

/**
 * This class represent an Alpaca creating Factory
 *
 * @author Martin Araya
 * @since 2.4
 */
public class AlpacaFactory extends AbstractUnitFactory {
    /**
     * Creates a new Alpaca with the parameters stored in the class
     *
     * @return the newly created Alpaca
     */
    @Override
    public Alpaca create() {
        return new Alpaca(this.getHitPoints(),this.getMovement(),this.getLocation());
    }
}
