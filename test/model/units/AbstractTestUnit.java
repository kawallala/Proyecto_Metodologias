package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.items.*;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
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

    /**
     * Set up the game field
     */
    @Override
    public void setField() {
        this.field = new Field();
        this.field.addCells(true,
                new Location(0, 0), new Location(0, 1), new Location(0, 2),
                new Location(1, 0), new Location(1, 1), new Location(1, 2),
                new Location(2, 0), new Location(2, 1), new Location(2, 2));
    }

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public abstract void setTestUnit();

    /**
     * Creeates an Alpaca to be used as an obstacle in the
     */
    //TODO ver si esto puede ser mejorado, no me gusta actualmente
    public void setTargetAlpaca() {
        this.targetAlpaca = new Alpaca(50, 2, field.getCell(1, 1));
    }

    @Override
    public abstract void setTargetUnits();

    /**
     * Creates a set of testing weapons
     */
    @Override
    public void setWeapons() {
        this.axe = new Axe("Axe", 10, 1, 2);
        this.sword = new Sword("Sword", 10, 1, 2);
        this.spear = new Spear("Spear", 10, 1, 2);
        this.staff = new Staff("Staff", 10, 1, 2);
        this.bow = new Bow("Bow", 10, 2, 3);
    }

    /**
     * Sets up the units and weapons to be tested
     */
    @BeforeEach
    public void setUp() {
        setField();
        setTestUnit();
        setTargetAlpaca();
        setTargetUnits();
        setWeapons();
    }

    /**
     * Checks that the constructor works properly.
     */
    @Override
    @Test
    public void constructorTest() {
        assertEquals(50, getTestUnit().getCurrentHitPoints());
        assertEquals(2, getTestUnit().getMovement());
        assertEquals(new Location(0, 0), getTestUnit().getLocation());
        assertTrue(getTestUnit().getItems().isEmpty());
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public abstract IUnit getTestUnit();

    /**
     * @return the test field
     */
    @Override
    public Field getField() {
        return field;
    }

    /**
     * Tries to equip a weapon to the unit and verifies that it was not equipped
     *
     * @param item to be equipped
     */
    @Override
    public void checkItemNotEquipped(IEquipableItem item) {
        assertNull(getTestUnit().getEquippedItem());
        item.equipTo(getTestUnit());
        assertNull(getTestUnit().getEquippedItem());
    }

    /**
     * Checks that the axe is not equipped correctly to the unit
     */
    @Override
    @Test
    public void equipAxeTest() {
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(getAxe());
    }

    /**
     * @return the test axe
     */
    @Override
    public Axe getAxe() {
        return axe;
    }

    /**
     * Checks that the Sword is not equipped correctly to the unit
     */
    @Override
    @Test
    public void equipSwordTest() {
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(getSword());
    }

    /**
     * @return the test sword
     */
    @Override
    public Sword getSword() {
        return sword;
    }

    /**
     * Checks that the Spear is not equipped correctly to the unit
     */
    @Override
    @Test
    public void equipSpearTest() {
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(getSpear());
    }

    /**
     * @return the test spear
     */
    @Override
    public Spear getSpear() {
        return spear;
    }

    /**
     * Checks that the Staff is not equipped correctly to the unit
     */
    @Override
    @Test
    public void equipStaffTest() {
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(getStaff());
    }

    /**
     * @return the test staff
     */
    @Override
    public Staff getStaff() {
        return staff;
    }

    /**
     * Checks that the Bow is not equipped correctly to the unit
     */
    @Override
    @Test
    public void equipBowTest() {
        assertNull(getTestUnit().getEquippedItem());
        checkItemNotEquipped(getBow());
    }

    /**
     * @return the test bow
     */
    @Override
    public Bow getBow() {
        return bow;
    }

    /**
     * Checks if the unit moves correctly
     */
    @Override
    @Test
    public void testMovement() {
        getTestUnit().moveTo(getField().getCell(2, 2));
        assertEquals(new Location(0, 0), getTestUnit().getLocation());

        getTestUnit().moveTo(getField().getCell(0, 2));
        assertEquals(new Location(0, 2), getTestUnit().getLocation());
        assertNull(getField().getCell(0, 0).getUnit());

        getField().getCell(0, 1).setUnit(getTargetAlpaca());
        getTestUnit().moveTo(getField().getCell(0, 1));
        assertEquals(new Location(0, 2), getTestUnit().getLocation());
    }

    /**
     * @return the target Alpaca
     */
    @Override
    public Alpaca getTargetAlpaca() {
        return targetAlpaca;
    }

    /**
     * @return the target Archer
     */
    @Override
    public Archer getTargetArcher() {
        return targetArcher;
    }

    /**
     * @return the target Cleric
     */
    @Override
    public Cleric getTargetCleric() {
        return targetCleric;
    }

    /**
     * @return the target Fighter
     */
    @Override
    public Fighter getTargetFighter() {
        return targetFighter;
    }

    /**
     * @return the target Hero
     */
    @Override
    public Hero getTargetHero() {
        return targetHero;
    }

    /**
     * @return the target SwordMaster
     */
    @Override
    public SwordMaster getTargetSwordMaster() {
        return targetSwordMaster;
    }

    @Override
    @Test
    public void testAttackTargetAlpaca(){
        //purposely left empty
    }
}
