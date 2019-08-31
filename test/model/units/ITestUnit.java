package model.units;


import model.items.*;
import model.map.Field;
import org.junit.jupiter.api.Test;

/**
 * Interface that defines the common behaviour of all the test for the units classes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface ITestUnit {

    /**
     * Set up the game field
     */
    void setField();

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    void setTestUnit();


    /**
     * Creates a set of testing units
     */
    void setTargetUnits();

    /**
     * Creates a set of testing weapons
     */
    void setWeapons();

    /**
     * Checks that the constructor works properly.
     */
    @Test
    void constructorTest();

    /**
     * @return the current unit being tested
     */
    IUnit getTestUnit();

    /**
     * Checks if the axe is equipped correctly to the unit
     */
    @Test
    void equipAxeTest();

    /**
     * Tries to equip an unaccepted item for the unit, and checks that it was not equipped
     *
     * @param item Item to be equipped
     */
    void checkItemNotEquipped(IEquipableItem item);

    /**
     * @return the test axe
     */
    Axe getAxe();

    @Test
    void equipSwordTest();

    /**
     * @return the test sword
     */
    Sword getSword();

    @Test
    void equipSpearTest();

    /**
     * @return the test spear
     */
    Spear getSpear();

    @Test
    void equipStaffTest();

    /**
     * @return the test staff
     */
    Staff getStaff();

    @Test
    void equipBowTest();

    /**
     * @return the test bow
     */
    Bow getBow();

    /**
     * Checks if the unit moves correctly
     */
    @Test
    void testMovement();

    /**
     * @return the test field
     */
    Field getField();

    /**
     * @return the target Alpaca
     */
    Alpaca getTargetAlpaca();

    /**
     * @return the target Archer
     */
    Archer getTargetArcher();

    /**
     * @return the target Cleric
     */
    Cleric getTargetCleric();

    /**
     * @return the target Fighter
     */
    Fighter getTargetFighter();

    /**
     * @return the target Hero
     */
    Hero getTargetHero();

    /**
     * @return the target SwordMaster
     */
    SwordMaster getTargetSwordMaster();

    /**
     * test attacks against an alpaca, it cannot attack back
     */
    @Test
    void testAttackNeutralTarget();

    @Test
    void testAttackStrongTarget();

    @Test
    void testAttackWeakTarget();

    @Test
    void testAttackTargetAlpaca();

    @Test
    void testAttackTargetArcher();

    @Test
    void testAttackTargetCleric();

}
