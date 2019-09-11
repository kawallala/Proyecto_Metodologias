package model.units;

import model.items.IEquipableItem;
import model.items.offensive.physical.Sword;
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
        swordMaster = new SwordMaster(100, 2, field.getCell(0, 0));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return swordMaster;
    }

    @Override
    public IEquipableItem getCorrespondingWeapon() {
        return sword;
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
    public void testCombatTargetFighter() {
        swordMaster.addToInventory(sword);
        swordMaster.equip(sword);

        targetFighter.addToInventory(axe);
        targetFighter.equip(axe);

        //in range
        targetFighter.moveTo(field.getCell(0, 1));
        assertEquals(100, targetFighter.getCurrentHitPoints());
        swordMaster.beginCombat(targetFighter);
        assertEquals(62, targetFighter.getCurrentHitPoints());
        assertEquals(95, swordMaster.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetFighter.moveTo(field.getCell(2, 2));
        swordMaster.beginCombat(targetFighter);
        assertEquals(62, targetFighter.getCurrentHitPoints());
        assertEquals(95, swordMaster.getCurrentHitPoints());
    }
    @Test
    @Override
    public void testCombatTargetHero() {
        swordMaster.addToInventory(sword);
        swordMaster.equip(sword);

        targetHero.addToInventory(spear);
        targetHero.equip(spear);

        //in range
        targetHero.moveTo(field.getCell(0, 1));
        assertEquals(100, targetHero.getCurrentHitPoints());
        swordMaster.beginCombat(targetHero);
        assertEquals(95, targetHero.getCurrentHitPoints());
        assertEquals(62, swordMaster.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetHero.moveTo(field.getCell(2, 2));
        swordMaster.beginCombat(targetHero);
        assertEquals(95, targetHero.getCurrentHitPoints());
        assertEquals(62, swordMaster.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetSwordMaster() {
        swordMaster.addToInventory(sword);
        swordMaster.equip(sword);

        Sword secondSword = new Sword("second sword", 25, 1, 2);
        targetSwordMaster.addToInventory(secondSword);
        targetSwordMaster.equip(secondSword);

        //in range
        targetSwordMaster.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSwordMaster.getCurrentHitPoints());
        swordMaster.beginCombat(targetSwordMaster);
        assertEquals(75, targetSwordMaster.getCurrentHitPoints());
        assertEquals(75, swordMaster.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSwordMaster.moveTo(field.getCell(2, 2));
        swordMaster.beginCombat(targetSwordMaster);
        assertEquals(75, targetSwordMaster.getCurrentHitPoints());
        assertEquals(75, swordMaster.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetSorcerer() {
        swordMaster.addToInventory(sword);
        swordMaster.equip(sword);

        targetSorcerer.addToInventory(animaMagicBook);
        targetSorcerer.equip(animaMagicBook);

        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        swordMaster.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, swordMaster.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        swordMaster.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, swordMaster.getCurrentHitPoints());
    }
}