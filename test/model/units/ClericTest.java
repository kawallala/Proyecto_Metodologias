package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.IEquipableItem;
import model.items.healing.Staff;
import org.junit.jupiter.api.Test;

/**
 * Test set for the Cleric unit.
 *
 * @author Martin Araya Zavala
 */
public class ClericTest extends AbstractTestUnit {

    private Cleric cleric;

    @Override
    public void setTestUnit() {
        cleric = new Cleric(100, 2, field.getCell(0, 0));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return cleric;
    }

    @Override
    public IEquipableItem getCorrespondingWeapon() {
        return staff;
    }

    private void healCleric(IUnit targetUnit, IEquipableItem targetItem){
        targetUnit.addToInventory(targetItem);
        targetItem.equipTo(targetUnit);
        targetUnit.normalDamage(95);

        cleric.addToInventory(staff);
        staff.equipTo(cleric);

        targetUnit.moveTo(getField().getCell(0,1));
        assertEquals(5, targetUnit.getCurrentHitPoints());
        cleric.beginCombat(targetUnit);
        assertEquals(30, targetUnit.getCurrentHitPoints());
        assertEquals(100, cleric.getCurrentHitPoints());
    }

    @Test
    @Override
    public void equipStaffTest() {
        assertNull(cleric.getEquippedItem());
        cleric.addToInventory(staff);
        staff.equipTo(cleric);
        assertEquals(staff, cleric.getEquippedItem());
    }

    /**
     * Test does nothing since the cleric cannot attack
     */
    @Test
    @Override
    public void testCombatTargetAlpaca() {
        cleric.addToInventory(staff);
        staff.equipTo(cleric);
        targetAlpaca.normalDamage(95);
        targetAlpaca.moveTo(getField().getCell(0,1));
        assertEquals(5, targetAlpaca.getCurrentHitPoints());
        cleric.beginCombat(targetAlpaca);
        assertEquals(30, targetAlpaca.getCurrentHitPoints());
        assertEquals(100, cleric.getCurrentHitPoints());
    }

    /**
     * Test does nothing since the cleric cannot attack
     */
    @Test
    @Override
    public void testCombatTargetArcher() {
        healCleric(targetArcher,bow);
    }

    /**
     * Test does nothing since the Cleric cannot attack
     */
    @Test
    @Override
    public void testCombatTargetCleric() {
        healCleric(targetCleric, new Staff("second staff", 25,1,2));
    }

    /**
     * Test does nothing since the Cleric cannot attack
     */
    @Override
    @Test
    public void testCombatTargetFighter() {
        healCleric(targetFighter,axe);
    }

    @Override
    @Test
    public void testCombatTargetHero() {
        healCleric(targetHero,spear);
    }

    /**
     * Test does nothing since the Cleric cannot attack
     */
    @Override
    @Test
    public void testCombatTargetSwordMaster() {
        healCleric(targetSwordMaster, sword);
    }

    @Override
    @Test
    public void testCombatTargetSorcerer() { healCleric(targetSorcerer,animaMagicBook);

    }
}