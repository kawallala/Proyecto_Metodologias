package model.units;

import model.items.*;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    protected Bow bow;
    protected Axe axe;
    protected Sword sword;
    protected Staff staff;
    protected Spear spear;


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

    }

    @Override
    public void setWeapons() {
        this.axe = new Axe("Axe", 25, 1, 2);
        this.sword = new Sword("Sword", 25, 1, 2);
        this.spear = new Spear("Spear", 25, 1, 2);
        this.staff = new Staff("Staff", 25, 1, 2);
        this.bow = new Bow("Bow", 25, 2, 3);
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
        getTestUnit().attack(targetAlpaca);
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
    public void testAttackTargetAlpaca() {
        getTestUnit().addToInventory(getCorrespondingWeapon());
        getCorrespondingWeapon().equipTo(getTestUnit());

        // in range - Alpaca
        targetAlpaca.moveTo(getField().getCell(0, 1));
        assertEquals(50, targetAlpaca.getCurrentHitPoints());
        getTestUnit().attack(targetAlpaca);
        assertEquals(40, targetAlpaca.getCurrentHitPoints());
        assertEquals(50, getTestUnit().getCurrentHitPoints());

        //out of range - Alpaca
        targetAlpaca.moveTo(getField().getCell(2, 2));
        getTestUnit().attack(targetAlpaca);
        assertEquals(40, targetAlpaca.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testAttackTargetArcher() {
        getTestUnit().addToInventory(getCorrespondingWeapon());
        getCorrespondingWeapon().equipTo(getTestUnit());

        targetArcher.addToInventory(bow);
        bow.equipTo(targetArcher);

        //in range, no counter attack
        targetArcher.moveTo(field.getCell(0, 1));
        assertEquals(50, targetArcher.getCurrentHitPoints());
        getTestUnit().attack(targetArcher);
        assertEquals(50 - 10, targetArcher.getCurrentHitPoints());
        assertEquals(50, getTestUnit().getCurrentHitPoints());

        //in range
        targetArcher.moveTo(field.getCell(0, 2));
        getTestUnit().attack(targetArcher);
        assertEquals(30, targetArcher.getCurrentHitPoints());
        assertEquals(40, getTestUnit().getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0, 1));
        targetArcher.moveTo(field.getCell(2, 2));
        getTestUnit().attack(targetArcher);
        assertEquals(30, targetArcher.getCurrentHitPoints());
        assertEquals(40, getTestUnit().getCurrentHitPoints());
    }

    @Override
    @Test
    public void testAttackTargetCleric() {
        getTestUnit().addToInventory(getCorrespondingWeapon());
        getCorrespondingWeapon().equipTo(getTestUnit());

        targetCleric.addToInventory(staff);
        staff.equipTo(targetCleric);

        //in range
        targetCleric.moveTo(field.getCell(0, 1));
        assertEquals(50, targetCleric.getCurrentHitPoints());
        getTestUnit().attack(targetCleric);
        assertEquals(40, targetCleric.getCurrentHitPoints());
        assertEquals(50, getTestUnit().getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0, 2));
        targetCleric.moveTo(field.getCell(2, 2));
        getTestUnit().attack(targetCleric);
        assertEquals(40, targetCleric.getCurrentHitPoints());
        assertEquals(50, getTestUnit().getCurrentHitPoints());
    }
}
