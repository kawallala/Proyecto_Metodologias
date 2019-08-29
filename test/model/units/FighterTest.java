package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.IEquipableItem;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class FighterTest extends AbstractTestUnit {

    private Fighter fighter;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        fighter = new Fighter(50, 2, field.getCell(0, 0));
    }

    @Override
    public void setTargetUnits() {

    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return fighter;
    }

    /**
     * Checks if the axe is equipped correctly to the unit
     */
    @Test
    @Override
    public void equipAxeTest() {
        assertNull(getTestUnit().getEquippedItem());
        getTestUnit().addToInventory(getAxe());
        getAxe().equipTo(getTestUnit());
        assertEquals(getAxe(), getTestUnit().getEquippedItem());
    }

    @Test
    @Override
    public void testAttackTargetAlpaca() {
        getTestUnit().addToInventory(getAxe());
        getAxe().equipTo(getTestUnit());
        getTargetAlpaca().moveTo(getField().getCell(0, 1));

        assertEquals(50, getTargetAlpaca().getCurrentHitPoints());

        getTestUnit().attack(getTargetAlpaca());
        assertEquals(50-10,getTargetAlpaca().getCurrentHitPoints());
    }
}