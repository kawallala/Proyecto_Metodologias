package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.offensive.magic.IMagicOffensiveItem;
import model.items.offensive.physical.Axe;
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
    public void testCombatTargetFighter() {
        fighter.addToInventory(axe);
        fighter.equip(axe);

        Axe secondAxe = new Axe("second axe", 25, 1,2);
        targetFighter.addToInventory(secondAxe);
        targetFighter.equip(secondAxe);

        //in range
        targetFighter.moveTo(field.getCell(0, 1));
        assertEquals(100, targetFighter.getCurrentHitPoints());
        fighter.beginCombat(targetFighter);
        assertEquals(75, targetFighter.getCurrentHitPoints());
        assertEquals(75, fighter.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetFighter.moveTo(field.getCell(2, 2));
        fighter.beginCombat(targetFighter);
        assertEquals(75, targetFighter.getCurrentHitPoints());
        assertEquals(75, fighter.getCurrentHitPoints());
    }
    @Test
    @Override
    public void testCombatTargetHero() {
        fighter.addToInventory(axe);
        fighter.equip(axe);

        targetHero.addToInventory(spear);
        targetHero.equip(spear);

        //in range
        targetHero.moveTo(field.getCell(0, 1));
        assertEquals(100, targetHero.getCurrentHitPoints());
        fighter.beginCombat(targetHero);
        assertEquals(62, targetHero.getCurrentHitPoints());
        assertEquals(95, fighter.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetHero.moveTo(field.getCell(2, 2));
        fighter.beginCombat(targetHero);
        assertEquals(62, targetHero.getCurrentHitPoints());
        assertEquals(95, fighter.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetSwordMaster() {
        fighter.addToInventory(axe);
        fighter.equip(axe);

        targetSwordMaster.addToInventory(sword);
        targetSwordMaster.equip(sword);

        //in range
        targetSwordMaster.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSwordMaster.getCurrentHitPoints());
        fighter.beginCombat(targetSwordMaster);
        assertEquals(95, targetSwordMaster.getCurrentHitPoints());
        assertEquals(62, fighter.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSwordMaster.moveTo(field.getCell(2, 2));
        fighter.beginCombat(targetSwordMaster);
        assertEquals(95, targetSwordMaster.getCurrentHitPoints());
        assertEquals(62, fighter.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetSorcerer() {
        fighter.addToInventory(axe);
        fighter.equip(axe);

        targetSorcerer.addToInventory(animaMagicBook);
        targetSorcerer.equip(animaMagicBook);

        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        fighter.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, fighter.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        fighter.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, fighter.getCurrentHitPoints());
    }
}