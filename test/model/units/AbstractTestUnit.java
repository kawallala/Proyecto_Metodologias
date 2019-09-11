package model.units;

import model.items.*;
import model.items.healing.Staff;
import model.items.offensive.magic.AnimaMagicBook;
import model.items.offensive.magic.DarkMagicBook;
import model.items.offensive.magic.IMagicOffensiveItem;
import model.items.offensive.magic.LightMagicBook;
import model.items.offensive.physical.Axe;
import model.items.offensive.physical.Bow;
import model.items.offensive.physical.Spear;
import model.items.offensive.physical.Sword;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Martin Araya Zavala
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

    protected Field field;

    protected Alpaca targetAlpaca;
    protected Archer targetArcher;
    protected Cleric targetCleric;
    protected Fighter targetFighter;
    protected Hero targetHero;
    protected SwordMaster targetSwordMaster;
    protected Sorcerer targetSorcerer;

    protected Bow bow;
    protected Axe axe;
    protected Sword sword;
    protected Staff staff;
    protected Spear spear;
    protected AnimaMagicBook animaMagicBook;
    protected DarkMagicBook darkMagicBook;
    protected LightMagicBook lightMagicBook;

    @Override
    public void setField() {
        this.field = new Field();
        this.field.addCells(true,
                new Location(0, 0), new Location(0, 1), new Location(0, 2), new Location(0, 3),
                new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(1, 3),
                new Location(2, 0), new Location(2, 1), new Location(2, 2), new Location(2, 3),
                new Location(3, 0), new Location(3, 1), new Location(3, 2), new Location(3, 3));
    }

    @Override
    public void setTargetUnits() {
        targetAlpaca = new Alpaca(100, 9, getField().getCell(2, 2));
        targetArcher = new Archer(100, 9, getField().getCell(2, 1));
        targetCleric = new Cleric(100, 9, getField().getCell(2, 0));
        targetFighter = new Fighter(100, 9, getField().getCell(1, 2));
        targetHero = new Hero(100, 9, getField().getCell(1, 1));
        targetSwordMaster = new SwordMaster(100, 9, getField().getCell(1, 0));
        targetSorcerer = new Sorcerer(100,9,getField().getCell(1,3));
    }

    @Override
    public void setWeapons() {
        this.axe = new Axe("Axe", 25, 1, 2);
        this.sword = new Sword("Sword", 25, 1, 2);
        this.spear = new Spear("Spear", 25, 1, 2);
        this.staff = new Staff("Staff", 25, 1, 2);
        this.bow = new Bow("Bow", 25, 2, 3);
        this.animaMagicBook = new AnimaMagicBook("Anima magic book",25,1,2);
        this.darkMagicBook = new DarkMagicBook("Dark magic book",25,1,2);
        this.lightMagicBook = new LightMagicBook("Light magic book",25,1,2);
    }

    @BeforeEach
    public void setUp() {
        setField();
        setWeapons();
        setTargetUnits();
        setTestUnit();
    }

    @Override
    @Test
    public void constructorTest() {
        assertEquals(100, getTestUnit().getCurrentHitPoints());
        assertEquals(2, getTestUnit().getMovement());
        assertEquals(getField().getCell(0, 0), getTestUnit().getLocation());
        assertTrue(getTestUnit().getItems().isEmpty());
    }

    @Override
    @Test
    public void deadUnitTest() {
        getTestUnit().strongDamage(200);
        assertEquals(0, getTestUnit().getCurrentHitPoints());
        getTestUnit().moveTo(getField().getCell(0,2));
        assertNull(getField().getCell(0,2).getUnit());
        assertEquals(getTestUnit(), getField().getCell(0,0).getUnit());
        getTestUnit().addToInventory(getCorrespondingWeapon());
        getCorrespondingWeapon().equipTo(getTestUnit());

        targetAlpaca.moveTo(getField().getCell(0,1));
        assertEquals(100, targetAlpaca.getCurrentHitPoints());
        getTestUnit().beginCombat(targetAlpaca);
        assertEquals(100, targetAlpaca.getCurrentHitPoints());
        assertEquals(0, getTestUnit().getCurrentHitPoints());
    }

    @Override
    public IEquipableItem getCorrespondingWeapon() {
        return null;
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    @Test
    public void testInventoryLimit() {
        assertEquals(new ArrayList<>(),getTestUnit().getItems());
        getTestUnit().addToInventory(axe);
        assertEquals(new ArrayList<>(Collections.singletonList(axe)),getTestUnit().getItems());
        //we try to add the same item to the inventory
        getTestUnit().addToInventory(axe);
        assertEquals(new ArrayList<>(Collections.singletonList(axe)),getTestUnit().getItems());

        //we fullfill the inventory and try to add another item
        getTestUnit().addToInventory(bow);
        getTestUnit().addToInventory(sword);
        assertEquals(new ArrayList<>(Arrays.asList(axe,bow,sword)),getTestUnit().getItems());
        getTestUnit().addToInventory(staff);
        assertEquals(new ArrayList<>(Arrays.asList(axe,bow,sword)),getTestUnit().getItems());

        targetAlpaca.addToInventory(animaMagicBook);
        getTestUnit().removeFromInventory(bow);
        getTestUnit().addToInventory(animaMagicBook);
        assertEquals(new ArrayList<>(Arrays.asList(axe,sword)),getTestUnit().getItems());
        assertEquals(new ArrayList<>(Collections.singletonList(animaMagicBook)),targetAlpaca.getItems());
    }

    @Override
    @Test
    public void testExchangeItems() {
        assertEquals(new ArrayList<>(),getTestUnit().getItems());
        targetAlpaca.addToInventory(axe);
        targetAlpaca.addToInventory(sword);
        targetAlpaca.addToInventory(bow);
        targetAlpaca.moveTo(getField().getCell(0,1));

        targetAlpaca.giveItem(axe,getTestUnit());
        assertEquals(new ArrayList<>(Collections.singletonList(axe)),getTestUnit().getItems());
        assertEquals(new ArrayList<>(Arrays.asList(sword,bow)),targetAlpaca.getItems());

        getTestUnit().giveItem(sword,targetAlpaca);
        assertEquals(new ArrayList<>(Collections.singletonList(axe)),getTestUnit().getItems());
        assertEquals(new ArrayList<>(Arrays.asList(sword,bow)),targetAlpaca.getItems());
    }

    @Override
    public void checkItemNotEquipped(IEquipableItem item) {
        assertNull(getTestUnit().getEquippedItem());
        item.equipTo(getTestUnit());
        assertNull(getTestUnit().getEquippedItem());
    }

    @Override
    @Test
    public void equipAxeTest() {
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(getAxe());
    }

    @Override
    public Axe getAxe() {
        return axe;
    }

    @Override
    @Test
    public void equipSwordTest() {
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(getSword());
    }

    @Override
    public Sword getSword() {
        return sword;
    }

    @Override
    @Test
    public void equipSpearTest() {
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(getSpear());
    }

    @Override
    public Spear getSpear() {
        return spear;
    }

    @Override
    @Test
    public void equipStaffTest() {
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(getStaff());
    }

    @Override
    public Staff getStaff() {
        return staff;
    }

    @Override
    @Test
    public void equipBowTest() {
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(getBow());
    }

    @Override
    public Bow getBow() {
        return bow;
    }

    @Override
    @Test
    public void equipIMagicOffensiveItem(){
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(animaMagicBook);
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(darkMagicBook);
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(lightMagicBook);
    }

    @Override
    @Test
    public void testMovement() {
        getTestUnit().moveTo(getField().getCell(2, 2));
        assertEquals(getField().getCell(0, 0), getTestUnit().getLocation());

        getTestUnit().moveTo(getField().getCell(0, 2));
        assertEquals(getField().getCell(0, 2), getTestUnit().getLocation());
        assertNull(getField().getCell(0, 0).getUnit());

        getTargetAlpaca().moveTo(getField().getCell(0, 1));
        getTestUnit().moveTo(getField().getCell(0, 1));
        assertEquals(getField().getCell(0, 2), getTestUnit().getLocation());
    }

    @Override
    public Alpaca getTargetAlpaca() {
        return targetAlpaca;
    }

    @Override
    public Archer getTargetArcher() {
        return targetArcher;
    }

    @Override
    public Cleric getTargetCleric() {
        return targetCleric;
    }

    @Override
    public Fighter getTargetFighter() {
        return targetFighter;
    }

    @Override
    public Hero getTargetHero() {
        return targetHero;
    }

    @Override
    public SwordMaster getTargetSwordMaster() {
        return targetSwordMaster;
    }

    @Override
    @Test
    public void testCombatTargetAlpaca() {
        getTestUnit().addToInventory(getCorrespondingWeapon());
        getCorrespondingWeapon().equipTo(getTestUnit());

        // in range - Alpaca
        targetAlpaca.moveTo(getField().getCell(0, 1));
        assertEquals(100, targetAlpaca.getCurrentHitPoints());
        getTestUnit().beginCombat(targetAlpaca);
        assertEquals(75, targetAlpaca.getCurrentHitPoints());
        assertEquals(100, getTestUnit().getCurrentHitPoints());

        //out of range - Alpaca
        targetAlpaca.moveTo(getField().getCell(2, 2));
        getTestUnit().beginCombat(targetAlpaca);
        assertEquals(75, targetAlpaca.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetArcher() {
        getTestUnit().addToInventory(getCorrespondingWeapon());
        getCorrespondingWeapon().equipTo(getTestUnit());

        targetArcher.addToInventory(bow);
        bow.equipTo(targetArcher);

        //in range, no counter attack
        targetArcher.moveTo(field.getCell(0, 1));
        assertEquals(100, targetArcher.getCurrentHitPoints());
        getTestUnit().beginCombat(targetArcher);
        assertEquals(75, targetArcher.getCurrentHitPoints());
        assertEquals(100, getTestUnit().getCurrentHitPoints());

        //in range
        targetArcher.moveTo(field.getCell(0, 2));
        getTestUnit().beginCombat(targetArcher);
        assertEquals(50, targetArcher.getCurrentHitPoints());
        assertEquals(75, getTestUnit().getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0, 1));
        targetArcher.moveTo(field.getCell(2, 2));
        getTestUnit().beginCombat(targetArcher);
        assertEquals(50, targetArcher.getCurrentHitPoints());
        assertEquals(75, getTestUnit().getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetCleric() {
        getTestUnit().addToInventory(getCorrespondingWeapon());
        getCorrespondingWeapon().equipTo(getTestUnit());

        targetCleric.addToInventory(staff);
        staff.equipTo(targetCleric);

        //in range
        targetCleric.moveTo(field.getCell(0, 1));
        assertEquals(100, targetCleric.getCurrentHitPoints());
        getTestUnit().beginCombat(targetCleric);
        assertEquals(75, targetCleric.getCurrentHitPoints());
        assertEquals(100, getTestUnit().getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0, 2));
        targetCleric.moveTo(field.getCell(2, 2));
        getTestUnit().beginCombat(targetCleric);
        assertEquals(75, targetCleric.getCurrentHitPoints());
        assertEquals(100, getTestUnit().getCurrentHitPoints());
    }
}
