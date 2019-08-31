package model.units;

import model.items.Bow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        archer.addToInventory(getBow());
        getBow().equipTo(archer);
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
    public void testAttackTargetAlpaca() {
        //attack in range
        getTargetAlpaca().moveTo(getField().getCell(0, 2));
        assertEquals(50, getTargetAlpaca().getCurrentHitPoints());
        archer.attack(getTargetAlpaca());
        assertEquals(50 - 10, getTargetAlpaca().getCurrentHitPoints());

        //attack out of range (inner range)
        getTargetAlpaca().moveTo(getField().getCell(0, 1));
        archer.attack(getTargetAlpaca());
        assertEquals(40, getTargetAlpaca().getCurrentHitPoints());

        //attack out of range(outer range)
        getTargetAlpaca().moveTo(getField().getCell(0, 3));
        getTargetAlpaca().moveTo(getField().getCell(0, 4));
        archer.attack(getTargetAlpaca());
        assertEquals(40, getTargetAlpaca().getCurrentHitPoints());
    }

    @Override
    @Test
    public void testAttackTargetArcher() {
        Bow secondBow = new Bow("second bow", 10, 2, 3);
        targetArcher.addToInventory(secondBow);
        secondBow.equipTo(targetArcher);

        //inner range, neither of them attack
        targetArcher.moveTo(field.getCell(0, 1));
        assertEquals(50, targetArcher.getCurrentHitPoints());
        archer.attack(targetArcher);
        assertEquals(50, targetArcher.getCurrentHitPoints());
        assertEquals(50, archer.getCurrentHitPoints());

        //normal range, both of them attack
        targetArcher.moveTo(field.getCell(0, 2));
        archer.attack(targetArcher);
        assertEquals(40, targetArcher.getCurrentHitPoints());
        assertEquals(40, archer.getCurrentHitPoints());

        //outer range, neither of them attack
        targetAlpaca.moveTo(field.getCell(0, 1));
        targetArcher.moveTo(field.getCell(2,2));
        archer.attack(targetArcher);
        assertEquals(40, targetArcher.getCurrentHitPoints());
        assertEquals(40, archer.getCurrentHitPoints());
    }

    @Test
    @Override
    public void testAttackTargetCleric() {
        //attack in range
        getTargetCleric().moveTo(getField().getCell(0, 2));
        assertEquals(50, getTargetCleric().getCurrentHitPoints());
        archer.attack(getTargetCleric());
        assertEquals(50 - 10, getTargetCleric().getCurrentHitPoints());

        //attack out of range (inner range)
        getTargetCleric().moveTo(getField().getCell(0, 1));
        archer.attack(getTargetCleric());
        assertEquals(40, getTargetCleric().getCurrentHitPoints());

        //attack out of range(outer range)
        getTargetAlpaca().moveTo(field.getCell(0, 1));
        getTargetCleric().moveTo(field.getCell(2,2));
        archer.attack(getTargetCleric());
        assertEquals(40, getTargetCleric().getCurrentHitPoints());
    }
}