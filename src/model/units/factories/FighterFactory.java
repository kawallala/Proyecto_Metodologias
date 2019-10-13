package model.units.factories;

import model.units.Fighter;
import model.units.IUnit;

/**
 * This classs represents a Fighter creatingFactory
 *
 * @author Martin Araya
 * @since 2.4
 */
public class FighterFactory extends AbstractUnitFactory {
    /**
     * Creates a fighter with the parameters stored in the factory
     *
     * @return The newly created fighter
     */
    @Override
    public IUnit create() {
        return new Fighter(this.getHitPoints(), this.getMovement(), this.getLocation());
    }
}
