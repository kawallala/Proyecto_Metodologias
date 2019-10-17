package model.units.factories;

import model.units.Hero;

/**
 * This class represents a Hero creating factory
 *
 * @author Martin Araya
 * @since 2.4
 */
public class HeroFactory extends AbstractUnitFactory {
    /**
     * Creates a Hero with the parameters stored in the factory
     *
     * @return The newly created Hero
     */
    @Override
    public Hero create() {
        Hero hero = new Hero(getHitPoints(), getMovement(), getLocation());
        setDefaults();
        return hero;
    }
}
