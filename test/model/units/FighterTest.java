package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Axe;
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
        fighter = new Fighter(100, 2, field.getCell(0, 0));

    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return fighter;
    }

    @Override
    public IEquipableItem getCorrespondingWeapon() {
        return axe;
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
        fighter.addToInventory(axe);
        axe.equipTo(fighter);

        Axe secondAxe = new Axe("second axe", 25, 1,2);
        targetFighter.addToInventory(secondAxe);
        secondAxe.equipTo(targetFighter);

        //in range
        targetFighter.moveTo(field.getCell(0, 1));
        assertEquals(100, targetFighter.getCurrentHitPoints());
        fighter.attack(targetFighter);
        assertEquals(75, targetFighter.getCurrentHitPoints());
        assertEquals(75, fighter.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetFighter.moveTo(field.getCell(2, 2));
        fighter.attack(targetFighter);
        assertEquals(75, targetFighter.getCurrentHitPoints());
        assertEquals(75, fighter.getCurrentHitPoints());
    }
    @Test
    @Override
    public void testAttackTargetHero() {
        fighter.addToInventory(axe);
        axe.equipTo(fighter);

        targetHero.addToInventory(spear);
        spear.equipTo(targetHero);

        //in range
        targetHero.moveTo(field.getCell(0, 1));
        assertEquals(100, targetHero.getCurrentHitPoints());
        fighter.attack(targetHero);
        assertEquals(62, targetHero.getCurrentHitPoints());
        assertEquals(95, fighter.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetHero.moveTo(field.getCell(2, 2));
        fighter.attack(targetHero);
        assertEquals(62, targetHero.getCurrentHitPoints());
        assertEquals(95, fighter.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testAttackTargetSwordMaster() {
        fighter.addToInventory(axe);
        axe.equipTo(fighter);

        targetSwordMaster.addToInventory(sword);
        sword.equipTo(targetSwordMaster);

        //in range
        targetSwordMaster.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSwordMaster.getCurrentHitPoints());
        fighter.attack(targetSwordMaster);
        assertEquals(95, targetSwordMaster.getCurrentHitPoints());
        assertEquals(62, fighter.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSwordMaster.moveTo(field.getCell(2, 2));
        fighter.attack(targetSwordMaster);
        assertEquals(95, targetSwordMaster.getCurrentHitPoints());
        assertEquals(62, fighter.getCurrentHitPoints());
    }

    @Override
    public void testAttackTargetSorcerer() {

    }
}