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
        targetHero = new Hero(50, 2, field.getCell(0,1));
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
    public void testAttackNeutralTarget() {
        fighter.addToInventory(axe);
        axe.equipTo(fighter);

        // in range
        getTargetAlpaca().moveTo(getField().getCell(0, 1));
        assertEquals(50, getTargetAlpaca().getCurrentHitPoints());
        fighter.attack(getTargetAlpaca());
        assertEquals(50-10,getTargetAlpaca().getCurrentHitPoints());

        //out of range
        getTargetAlpaca().moveTo(getField().getCell(0,2));
        getTargetAlpaca().moveTo(getField().getCell(1,2));
        fighter.attack(getTargetAlpaca());
        assertEquals(40, getTargetAlpaca().getCurrentHitPoints());
    }

    @Override
    @Test
    public void testAttackStrongTarget() {
        //TODO implementar ataque a todas las unidades
        fighter.addToInventory(axe);
        axe.equipTo(fighter);
        targetHero.addToInventory(spear);
        spear.equipTo(targetHero);
        //in range
        assertEquals(50,targetHero.getCurrentHitPoints());
        fighter.attack(targetHero);
        assertEquals(35,targetHero.getCurrentHitPoints());
        assertEquals(50, fighter.getCurrentHitPoints());

        //out of range
        targetHero.moveTo(getField().getCell(1,2));
        fighter.attack(targetHero);
        assertEquals(35, targetHero.getCurrentHitPoints());
        assertEquals(50, fighter.getCurrentHitPoints());
    }

    @Override
    public void testAttackWeakTarget() {

    }
}