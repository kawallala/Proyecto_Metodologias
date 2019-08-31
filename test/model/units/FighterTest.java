package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Axe;
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
        fighter.addToInventory(getAxe());
        getAxe().equipTo(fighter);
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
        assertNull(fighter.getEquippedItem());
        fighter.addToInventory(axe);
        axe.equipTo(fighter);
        assertEquals(axe, fighter.getEquippedItem());
    }
    @Test
    @Override
    public void testAttackTargetFighter() {
        Axe secondAxe = new Axe("second axe", 10, 1,2);
        targetFighter.addToInventory(secondAxe);
        secondAxe.equipTo(targetFighter);

        //in range
        targetFighter.moveTo(field.getCell(0, 1));
        assertEquals(50, targetFighter.getCurrentHitPoints());
        fighter.attack(targetFighter);
        assertEquals(40, targetFighter.getCurrentHitPoints());
        assertEquals(40, fighter.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetFighter.moveTo(field.getCell(2, 2));
        fighter.attack(targetFighter);
        assertEquals(40, targetFighter.getCurrentHitPoints());
        assertEquals(40, fighter.getCurrentHitPoints());
    }

    @Override
    public void testAttackTargetHero() {

    }
}