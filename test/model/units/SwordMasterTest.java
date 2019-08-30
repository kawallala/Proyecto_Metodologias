package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Ignacio Slater Muñoz
 */
public class SwordMasterTest extends AbstractTestUnit {

    private SwordMaster swordMaster;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        swordMaster = new SwordMaster(50, 2, field.getCell(0, 0));
        swordMaster.addToInventory(sword);
        sword.equipTo(swordMaster);
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return swordMaster;
    }

    @Override
    @Test
    public void equipSwordTest() {
        assertNull(swordMaster.getEquippedItem());
        getTestUnit().addToInventory(getSword());
        this.sword.equipTo(this.swordMaster);
        assertEquals(sword, swordMaster.getEquippedItem());
    }

    @Override
    @Test
    public void testAttackNeutralTarget() {
        getTestUnit().addToInventory(getSword());
        getSword().equipTo(getTestUnit());
        getTargetAlpaca().moveTo(getField().getCell(0, 1));

        assertEquals(50, getTargetAlpaca().getCurrentHitPoints());

        getTestUnit().attack(getTargetAlpaca());
        assertEquals(50-10,getTargetAlpaca().getCurrentHitPoints());
    }

    @Override
    public void testAttackStrongTarget() {

    }

    @Override
    public void testAttackWeakTarget() {

    }
}