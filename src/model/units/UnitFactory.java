package model.units;

import model.items.IEquipableItem;
import model.map.Location;

import java.util.ArrayList;
import java.util.Arrays;

public class UnitFactory implements IFactory {
    private int hitpoints = 100;
    private int movement = 2;
    private Location location = new Location(0, 0);

    @Override
    public void setHitpoints(final int hitpoints) {
        this.hitpoints = hitpoints;
    }

    @Override
    public void setMovement(final int movement) {
        this.movement = movement;
    }

    @Override
    public void setLocation(final Location location) {
        this.location = location;
    }

    @Override
    public Alpaca createAlpaca() {
        return new Alpaca(hitpoints,movement,location);
    }

    @Override
    public Archer createArcher() {
        return new Archer(hitpoints,movement,location);
    }

    @Override
    public Cleric createCleric() {
        return new Cleric(hitpoints,movement,location);
    }

    @Override
    public Fighter createFighter() {
        return new Fighter(hitpoints,movement,location);
    }

    @Override
    public Hero createHero() {
        return new Hero(hitpoints,movement,location);
    }

    @Override
    public Sorcerer createSorcerer() {
        return new Sorcerer(hitpoints,movement,location);
    }

    @Override
    public SwordMaster createSwordMaster() {
        return new SwordMaster(hitpoints,movement,location);
    }
}
