package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class ClericTest extends AbstractTestUnit {

    private Cleric cleric;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        cleric = new Cleric(50, 2, field.getCell(0, 0));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return cleric;
    }

    @Test
    @Override
    public void equipStaffTest() {
        assertNull(cleric.getEquippedItem());
        cleric.addToInventory(staff);
        staff.equipTo(cleric);
        assertEquals(staff, cleric.getEquippedItem());
    }

    /**
     * Test does nothing since the cleric cannot attack
     */
    @Test
    @Override
    public void testAttackTargetAlpaca() {
        //purposely left empty
    }

    /**
     * Test does nothing since the cleric cannot attack
     */
    @Test
    @Override
    public void testAttackTargetArcher() {
        //purposely left empty
    }
}