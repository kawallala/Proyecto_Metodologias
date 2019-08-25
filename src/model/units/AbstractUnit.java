package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.items.*;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

    protected final List<IEquipableItem> items = new ArrayList<>();
    private int currentHitPoints;
    private int maximumHitPoints;
    private final int movement;
    protected IEquipableItem equippedItem;
    private Location location;

    /**
     * Creates a new Unit.
     *
     * @param hitPoints the maximum amount of damage a unit can sustain
     * @param movement  the number of panels a unit can move
     * @param location  the current position of this unit on the map
     * @param maxItems  maximum amount of items this unit can carry
     */
    protected AbstractUnit(int hitPoints, final int movement,
                           final Location location, final int maxItems, final IEquipableItem... items) {
        if (movement < 0) throw new AssertionError();
        if (hitPoints < 1) throw new AssertionError();
        this.maximumHitPoints = hitPoints;
        setCurrentHitPoints(maximumHitPoints);
        this.movement = movement;
        setLocation(location);
        this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
    }

    @Override
    public int getCurrentHitPoints() {
        return this.currentHitPoints;
    }

    @Override
    public void setCurrentHitPoints(int hitPoints) {
        this.currentHitPoints = hitPoints;
    }

    @Override
    public List<IEquipableItem> getItems() {
        return List.copyOf(this.items);
    }

    @Override
    public IEquipableItem getEquippedItem() {
        return this.equippedItem;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(final Location location) {
        location.setUnit(this);
        this.location = location;
    }

    @Override
    public int getMovement() {
        return this.movement;
    }

    @Override
    public void moveTo(final Location targetLocation) {
        if (this.getLocation().distanceTo(targetLocation) <= this.getMovement() && targetLocation.getUnit() == null) {
            setLocation(targetLocation);
        }
    }

    @Override
    public void equipBow(Bow bow) {
        //purposely left empty :c
    }

    @Override
    public void equipStaff(Staff staff) {
        //purposely left empty :c
    }

    @Override
    public void equipAxe(Axe axe) {
        //purposely left empty :c
    }

    @Override
    public void equipSpear(Spear spear) {
        //purposely left empty :c
    }

    @Override
    public void equipSword(Sword sword) {
        //purposely left empty :c
    }

    @Override
    public void attack(IUnit targetUnit) {
        if (targetUnit.getLocation().distanceTo(this.getLocation()) <= this.equippedItem.getMaxRange()) {
            targetUnit.setCurrentHitPoints(targetUnit.getCurrentHitPoints() - this.equippedItem.getPower());
        }
    }
}
