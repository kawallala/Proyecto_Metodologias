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

    @Test
    @Override
    public void testAttackTargetFighter() {
        targetFighter.addToInventory(axe);
        axe.equipTo(targetFighter);

        //in range
        targetFighter.moveTo(field.getCell(0, 1));
        assertEquals(50, targetFighter.getCurrentHitPoints());
        swordMaster.attack(targetFighter);
        assertEquals(35, targetFighter.getCurrentHitPoints());
        assertEquals(50, swordMaster.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetFighter.moveTo(field.getCell(2, 2));
        swordMaster.attack(targetFighter);
        assertEquals(35, targetFighter.getCurrentHitPoints());
        assertEquals(50, swordMaster.getCurrentHitPoints());
    }

    @Override
    public void testAttackTargetHero() {

    }
}