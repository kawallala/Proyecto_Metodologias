package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

    private Archer archer;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        archer = new Archer(50, 2, field.getCell(0, 0));
    }

    @Override
    public void setTargetUnits() {

    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return archer;
    }

    /**
     * Checks if the bow is equipped correctly to the unit
     */
    @Test
    @Override
    public void equipBowTest() {
        assertNull(archer.getEquippedItem());
        archer.addToInventory(bow);
        bow.equipTo(archer);
        assertEquals(bow, archer.getEquippedItem());
    }

    @Test
    @Override
    public void testAttackNeutralTarget() {
        archer.addToInventory(getBow());
        getBow().equipTo(archer);

        //attack in range
        getTargetAlpaca().moveTo(getField().getCell(0, 2));
        assertEquals(50, getTargetAlpaca().getCurrentHitPoints());
        archer.attack(getTargetAlpaca());
        assertEquals(50-10,getTargetAlpaca().getCurrentHitPoints());

        //attack out of range (inner range)
        getTargetAlpaca().moveTo(getField().getCell(0,1));
        archer.attack(getTargetAlpaca());
        assertEquals(40, getTargetAlpaca().getCurrentHitPoints());

        //attack out of range(outer range)
        getTargetAlpaca().moveTo(getField().getCell(0,3));
        getTargetAlpaca().moveTo(getField().getCell(0,4));
        archer.attack(getTargetAlpaca());
        assertEquals(40, getTargetAlpaca().getCurrentHitPoints());
    }
}