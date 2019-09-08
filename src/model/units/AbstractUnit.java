package model.units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.items.*;
import model.items.healing.Staff;
import model.items.offensive.magic.IMagicOffensiveItem;
import model.items.offensive.magic.AbstractMagicOffensiveItem;
import model.items.offensive.physical.*;
import model.map.Location;

import static java.lang.Math.*;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Martin Araya Zavala
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

    @Override
    public List<IEquipableItem> getItems() {
        return List.copyOf(this.items);
    }

    @Override
    public IEquipableItem getEquippedItem() {
        return this.equippedItem;
    }

    @Override
    public int getMaximumItems() {
        return this.maxItems;
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
        if (this.getLocation().distanceTo(targetLocation) <= this.getMovement() && targetLocation.getUnit() == null && currentHitPoints >= 1) {
            getLocation().removeUnit();
            setLocation(targetLocation);
        }
    }

    @Override
    public void equip(IEquipableItem item) {
        item.equipTo(this);
    }

    @Override
    public void unequip() {
        if(equippedItem != null){
            equippedItem.setOwner(null);
            equippedItem = null;
        }
    }

    @Override
    public void attackedByPhysicalOffensiveItem(IPhysicalOffensiveItem physicalOffensiveItem) {
        if(getEquippedItem() == null){
            normalDamage(physicalOffensiveItem.getPower());
        }else {
            equippedItem.ownerAttackedByPhysicalOffensiveItem(physicalOffensiveItem);
        }
    }

    @Override
    public void equipAxe(Axe axe) {
        //purposely left empty :c
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
    public void equipSpear(Spear spear) {
        //purposely left empty :c
    }

    @Override
    public void equipSword(Sword sword) {
        //purposely left empty :c
    }

    @Override
    public void equipMagicOffensiveItem(AbstractMagicOffensiveItem magicOffensiveItem) {
        //purposely left empty
    }

    @Override
    public void attackedByMagicOffensiveItem(IMagicOffensiveItem magicOffensiveItem) {
        if(equippedItem == null){
            normalDamage(magicOffensiveItem.getPower());
        }
        else {
            equippedItem.ownerAttackedByMagicOffensiveItem(magicOffensiveItem);
        }
    }

    @Override
    public void attack(IUnit targetUnit) {
        double distance = this.getLocation().distanceTo(targetUnit.getLocation());
        if(getEquippedItem() != null &&
                getEquippedItem().getMinRange()<= distance &&
                getEquippedItem().getMaxRange()>= distance &&
                this.getCurrentHitPoints() >= 1) {
            this.getEquippedItem().use(targetUnit);
            targetUnit.counterAttack(this);
        }
    }

    @Override
    public void counterAttack(IUnit targetUnit) {
        double distance = this.getLocation().distanceTo(targetUnit.getLocation());
        if(getEquippedItem() != null &&
                getEquippedItem().getMinRange()<= distance &&
                getEquippedItem().getMaxRange()>= distance &&
                getCurrentHitPoints()>=1) {
            this.getEquippedItem().use(targetUnit);
        }
    }

    @Override
    public void normalDamage(int damage) {
        currentHitPoints = max(0, currentHitPoints-damage);
    }

    @Override
    public void strongDamage(int damage) {
        currentHitPoints = (int) max(0, currentHitPoints-damage*1.5);
    }

    @Override
    public void weakDamage(int damage) {
        currentHitPoints = max(0, currentHitPoints - (damage>20?(damage-20):0));
    }

    @Override
    public void addToInventory(IEquipableItem item) {
        if (this.items.size() < this.maxItems && !this.items.contains(item)){
            this.items.add(item);
        }
    }

    @Override
    public void removeFromInventory(IEquipableItem item) {
        if(this.items.contains(item)){
            unequip();
            this.items.remove(item);
        }
    }

    @Override
    public void giveItem(IEquipableItem item, IUnit receivingUnit) {
        if(this.items.contains(item) && receivingUnit.getItems().size() < receivingUnit.getMaximumItems()){
            removeFromInventory(item);
            receivingUnit.addToInventory(item);
        }
    }

    @Override
    public void heal(int healingPower) {
        this.currentHitPoints = min(maximumHitPoints, currentHitPoints+healingPower);
    }
}
