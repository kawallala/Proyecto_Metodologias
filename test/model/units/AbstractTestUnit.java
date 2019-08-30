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
                new Location(0, 0), new Location(0, 1), new Location(0, 2),
                new Location(1, 0), new Location(1, 1), new Location(1, 2),
                new Location(2, 0), new Location(2, 1), new Location(2, 2));
    }

    @Override
    public abstract void setTestUnit();

    public void setTargetAlpaca() {
        this.targetAlpaca = new Alpaca(50, 2, field.getCell(1, 1));
    }

    @Override
    public abstract void setTargetUnits();

    @Override
    public void setWeapons() {
        this.axe = new Axe("Axe", 10, 1, 2);
        this.sword = new Sword("Sword", 10, 1, 2);
        this.spear = new Spear("Spear", 10, 1, 2);
        this.staff = new Staff("Staff", 10, 1, 2);
        this.bow = new Bow("Bow", 10, 2, 3);
    }

    @BeforeEach
    public void setUp() {
        setField();
        setTestUnit();
        setTargetAlpaca();
        setTargetUnits();
        setWeapons();
    }

    @Override
    @Test
    public void constructorTest() {
        assertEquals(50, getTestUnit().getCurrentHitPoints());
        assertEquals(2, getTestUnit().getMovement());
        assertEquals(getField().getCell(0,0), getTestUnit().getLocation());
        assertTrue(getTestUnit().getItems().isEmpty());
    }

    @Override
    public abstract IUnit getTestUnit();

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
        assertEquals(getField().getCell(0,0), getTestUnit().getLocation());

        getTestUnit().moveTo(getField().getCell(0, 2));
        assertEquals(getField().getCell(0,2), getTestUnit().getLocation());
        assertNull(getField().getCell(0, 0).getUnit());

        getField().getCell(0, 1).setUnit(getTargetAlpaca());
        getTestUnit().moveTo(getField().getCell(0, 1));
        assertEquals(getField().getCell(0,2), getTestUnit().getLocation());
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
    public void testAttackNeutralTarget() {
        //purposely left empty
    }

    @Override
    public void testAttackStrongTarget() {
        //purposely left empty
    }

    @Override
    public void testAttackWeakTarget() {
        //purposely left empty
    }
}
