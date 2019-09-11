package model.units;

import model.items.offensive.physical.Bow;
import model.items.IEquipableItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test set for the Archer unit.
 *
 * @author Martin Araya Zavala
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

    private Archer archer;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        archer = new Archer(100, 2, field.getCell(0, 0));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return archer;
    }

    @Override
    public IEquipableItem getCorrespondingWeapon() {
        return bow;
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
    public void testCombatTargetAlpaca() {
        archer.addToInventory(bow);
        bow.equipTo(archer);

        //attack in range
        getTargetAlpaca().moveTo(getField().getCell(0, 2));
        assertEquals(100, getTargetAlpaca().getCurrentHitPoints());
        archer.beginCombat(getTargetAlpaca());
        assertEquals(75, getTargetAlpaca().getCurrentHitPoints());
        assertEquals(100, archer.getCurrentHitPoints());

        //attack out of range (inner range)
        getTargetAlpaca().moveTo(getField().getCell(0, 1));
        archer.beginCombat(getTargetAlpaca());
        assertEquals(75, getTargetAlpaca().getCurrentHitPoints());
        assertEquals(100, archer.getCurrentHitPoints());

        //attack out of range(outer range)
        getTargetAlpaca().moveTo(getField().getCell(3, 3));
        archer.beginCombat(getTargetAlpaca());
        assertEquals(75, getTargetAlpaca().getCurrentHitPoints());
        assertEquals(100, archer.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetArcher() {
        archer.addToInventory(bow);
        bow.equipTo(archer);

        Bow secondBow = new Bow("second bow", 25, 2, 3);
        targetArcher.addToInventory(secondBow);
        secondBow.equipTo(targetArcher);

        //inner range, neither of them attack
        targetArcher.moveTo(field.getCell(0, 1));
        assertEquals(100, targetArcher.getCurrentHitPoints());
        archer.beginCombat(targetArcher);
        assertEquals(100, targetArcher.getCurrentHitPoints());
        assertEquals(100, archer.getCurrentHitPoints());

        //normal range, both of them attack
        targetArcher.moveTo(field.getCell(0, 2));
        archer.beginCombat(targetArcher);
        assertEquals(75, targetArcher.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());

        //outer range, neither of them attack
        targetAlpaca.moveTo(field.getCell(0, 1));
        targetArcher.moveTo(field.getCell(2,2));
        archer.beginCombat(targetArcher);
        assertEquals(75, targetArcher.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());
    }

    @Test
    @Override
    public void testCombatTargetCleric() {
        archer.addToInventory(bow);
        bow.equipTo(archer);
        //attack in range, with counter attack
        targetCleric.moveTo(getField().getCell(0, 2));
        assertEquals(100, targetCleric.getCurrentHitPoints());
        archer.beginCombat(targetCleric);
        assertEquals(75, targetCleric.getCurrentHitPoints());
        assertEquals(100, archer.getCurrentHitPoints());

        //attack out of range (inner range)
        targetCleric.moveTo(getField().getCell(0, 1));
        archer.beginCombat(targetCleric);
        assertEquals(75, targetCleric.getCurrentHitPoints());
        assertEquals(100, archer.getCurrentHitPoints());

        //attack out of range(outer range)
        getTargetAlpaca().moveTo(field.getCell(0, 1));
        targetCleric.moveTo(field.getCell(2,2));
        archer.beginCombat(targetCleric);
        assertEquals(75, targetCleric.getCurrentHitPoints());
        assertEquals(100, archer.getCurrentHitPoints());
    }

    @Test
    @Override
    public void testCombatTargetFighter() {
        archer.addToInventory(bow);
        bow.equipTo(archer);

        targetFighter.addToInventory(axe);
        axe.equipTo(targetFighter);

        //attack in range - counter attack is done
        targetFighter.moveTo(getField().getCell(0, 2));
        assertEquals(100, targetFighter.getCurrentHitPoints());
        archer.beginCombat(targetFighter);
        assertEquals(75, targetFighter.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());

        //attack in range - no counter attack
        targetFighter.moveTo(getField().getCell(1, 2));
        archer.beginCombat(targetFighter);
        assertEquals(50, targetFighter.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());

        //attack out of range (inner range)
        targetFighter.moveTo(getField().getCell(0, 1));
        archer.beginCombat(targetFighter);
        assertEquals(50, targetFighter.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());

        //attack out of range(outer range)
        getTargetAlpaca().moveTo(field.getCell(0, 1));
        targetFighter.moveTo(field.getCell(2,2));
        archer.beginCombat(targetFighter);
        assertEquals(50, targetFighter.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());
    }

    @Test
    @Override
    public void testCombatTargetHero() {
        archer.addToInventory(bow);
        bow.equipTo(archer);

        targetHero.addToInventory(spear);
        spear.equipTo(targetHero);

        //attack in range - counter attack is done
        targetHero.moveTo(getField().getCell(0, 2));
        assertEquals(100, targetHero.getCurrentHitPoints());
        archer.beginCombat(targetHero);
        assertEquals(75, targetHero.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());

        //attack in range - no counter attack
        targetFighter.moveTo(getField().getCell(0, 1));
        targetHero.moveTo(getField().getCell(1,2));
        archer.beginCombat(targetHero);
        assertEquals(50, targetHero.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());

        //attack out of range (inner range)
        targetHero.moveTo(getField().getCell(0, 2));
        targetFighter.moveTo(getField().getCell(1, 2));
        targetHero.moveTo(getField().getCell(0,1));
        archer.beginCombat(targetHero);
        assertEquals(50, targetHero.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());

        //attack out of range(outer range)
        getTargetAlpaca().moveTo(field.getCell(0, 1));
        targetHero.moveTo(field.getCell(2,2));
        archer.beginCombat(targetHero);
        assertEquals(50, targetHero.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetSwordMaster() {
        archer.addToInventory(bow);
        bow.equipTo(archer);

        targetSwordMaster.addToInventory(sword);
        sword.equipTo(targetSwordMaster);

        //attack in range - counter attack is done
        targetSwordMaster.moveTo(getField().getCell(0, 2));
        assertEquals(100, targetSwordMaster.getCurrentHitPoints());
        archer.beginCombat(targetSwordMaster);
        assertEquals(75, targetSwordMaster.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());

        //attack in range - no counter attack
        targetFighter.moveTo(getField().getCell(0, 1));
        targetSwordMaster.moveTo(getField().getCell(1,2));
        archer.beginCombat(targetSwordMaster);
        assertEquals(50, targetSwordMaster.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());

        //attack out of range (inner range)
        targetSwordMaster.moveTo(getField().getCell(0, 2));
        targetFighter.moveTo(getField().getCell(1, 2));
        targetSwordMaster.moveTo(getField().getCell(0,1));
        archer.beginCombat(targetSwordMaster);
        assertEquals(50, targetSwordMaster.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());

        //attack out of range(outer range)
        getTargetAlpaca().moveTo(field.getCell(0, 1));
        targetSwordMaster.moveTo(field.getCell(2,2));
        archer.beginCombat(targetSwordMaster);
        assertEquals(50, targetSwordMaster.getCurrentHitPoints());
        assertEquals(75, archer.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetSorcerer() {
        archer.addToInventory(bow);
        bow.equipTo(archer);

        targetSorcerer.addToInventory(animaMagicBook);
        targetSorcerer.equip(animaMagicBook);

        //attack in range - counter attack is done
        targetSorcerer.moveTo(getField().getCell(0, 2));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        archer.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, archer.getCurrentHitPoints());

        //attack in range - no counter attack
        targetFighter.moveTo(getField().getCell(0, 1));
        targetSorcerer.moveTo(getField().getCell(1,2));
        archer.beginCombat(targetSorcerer);
        assertEquals(24, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, archer.getCurrentHitPoints());

        //attack out of range (inner range)
        targetSorcerer.moveTo(getField().getCell(0, 2));
        targetFighter.moveTo(getField().getCell(1, 2));
        targetSorcerer.moveTo(getField().getCell(0,1));
        archer.beginCombat(targetSorcerer);
        assertEquals(24, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, archer.getCurrentHitPoints());

        //attack out of range(outer range)
        getTargetAlpaca().moveTo(field.getCell(0, 1));
        targetSorcerer.moveTo(field.getCell(2,2));
        archer.beginCombat(targetSorcerer);
        assertEquals(24, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, archer.getCurrentHitPoints());
    }
}