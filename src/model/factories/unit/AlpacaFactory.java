package model.factories.unit;

import model.units.Alpaca;

/**
 * This class represents an Alpaca creating Factory
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
        Alpaca alpaca = new Alpaca(getHitPoints(),getMovement(),getLocation());
        setDefaults();
        return alpaca;
    }
}
