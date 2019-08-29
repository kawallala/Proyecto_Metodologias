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
    private final int maxItems;
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
        this.maximumHitPoints = hitPoints;
        this.currentHitPoints = this.maximumHitPoints;
        this.movement = movement;
        this.maxItems = maxItems;
        setLocation(location);
        this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
    }

    @Override
    public int getMaximumHitPoints() {
        return this.maximumHitPoints;
    }

    @Override
    public int getCurrentHitPoints() {
        return this.currentHitPoints;
    }
    //TODO preguntar al auxs si eso se puede dejar private, y si no, porque no?
    @Override
    public void setCurrentHitPoints(int hitPoints) {
        this.currentHitPoints = hitPoints;
    }

    @Override
    public List<IEquipableItem> getItems() {
        return List.copyOf(this.items);
    }
    //TODO unequip item
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
            getLocation().removeUnit();
            setLocation(targetLocation);
        }
    }

    @Override
    public void equipAxe(Axe axe) {
        //purposely left empty :c
    }

    @Override
    public void attackedByAxe(Axe axe) {
        if(getEquippedItem() == null){
            normalDamage(axe.getPower());
        }
        else{
            getEquippedItem().ownerAttackedByAxe(axe);
        }
    }

    @Override
    public void equipBow(Bow bow) {
        //purposely left empty :c
    }

    @Override
    public void attackedByBow(Bow bow) {
        if(getEquippedItem() == null){
            normalDamage(bow.getPower());
        }
        else{
            getEquippedItem().ownerAttackedByBow(bow);
        }
    }

    @Override
    public void equipStaff(Staff staff) {
        //purposely left empty :c
    }

    @Override
    public void equipSpear(Spear spear) {
        //purposely left empty :c
    }

    @Override
    public void attackedBySpear(Spear spear) {
        if(getEquippedItem() == null){
            normalDamage(spear.getPower());
        }
        else{
            getEquippedItem().ownerAttackedBySpear(spear);
        }
    }

    @Override
    public void equipSword(Sword sword) {
        //purposely left empty :c
    }

    @Override
    public void attackedBySword(Sword sword) {
        if(getEquippedItem() == null){
            normalDamage(sword.getPower());
        }
        else{
            getEquippedItem().ownerAttackedBySword(sword);
        }
    }

    @Override
    public void attack(IUnit targetUnit) {
        double distance = this.getLocation().distanceTo(targetUnit.getLocation());
        if(getEquippedItem() != null &&
                getEquippedItem().getMinRange()<= distance &&
                getEquippedItem().getMaxRange()>= distance) {
            this.getEquippedItem().attackWith(targetUnit);
        }
        targetUnit.counterAttack(this);
    }

    @Override
    public void counterAttack(IUnit targetUnit) {
        double distance = this.getLocation().distanceTo(targetUnit.getLocation());
        if(getEquippedItem() != null &&
                getEquippedItem().getMinRange()<= distance &&
                getEquippedItem().getMaxRange()>= distance &&
                getCurrentHitPoints()>=1) {
            this.getEquippedItem().attackWith(targetUnit);
        }
    }

    @Override
    public void normalDamage(int damage) {
        setCurrentHitPoints(getCurrentHitPoints()-damage);
    }

    @Override
    public void addToInventory(IEquipableItem item) {
        if (this.items.size() <= this.maxItems){
            this.items.add(item);
        }
    }
}
