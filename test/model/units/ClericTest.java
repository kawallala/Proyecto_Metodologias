package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.IEquipableItem;
import model.items.Staff;
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

    private void nulldamageCleric(IUnit targetUnit, IEquipableItem targetItem){
        targetUnit.addToInventory(targetItem);
        targetItem.equipTo(targetUnit);

        cleric.addToInventory(staff);
        staff.equipTo(cleric);

        targetUnit.moveTo(getField().getCell(0,1));
        assertEquals(100, targetUnit.getCurrentHitPoints());
        cleric.attack(targetUnit);
        assertEquals(100, targetUnit.getCurrentHitPoints());
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
    public void testAttackTargetAlpaca() {
        cleric.addToInventory(staff);
        staff.equipTo(cleric);

        targetAlpaca.moveTo(getField().getCell(0,1));
        assertEquals(100, targetAlpaca.getCurrentHitPoints());
        cleric.attack(targetAlpaca);
        assertEquals(100, targetAlpaca.getCurrentHitPoints());
        assertEquals(100, cleric.getCurrentHitPoints());
    }

    /**
     * Test does nothing since the cleric cannot attack
     */
    @Test
    @Override
    public void testAttackTargetArcher() {
        nulldamageCleric(targetArcher,bow);
    }

    /**
     * Test does nothing since the Cleric cannot attack
     */
    @Test
    @Override
    public void testAttackTargetCleric() {
        nulldamageCleric(targetCleric,new Staff("second staff", 25,1,2));
    }

    /**
     * Test does nothing since the Cleric cannot attack
     */
    @Override
    public void testAttackTargetFighter() {
        nulldamageCleric(targetFighter,axe);
    }

    @Override
    public void testAttackTargetHero() {
        nulldamageCleric(targetHero,spear);
    }

    /**
     * Test does nothing since the Cleric cannot attack
     */
    @Override
    public void testAttackTargetSwordMaster() {
        nulldamageCleric(targetSwordMaster, sword);
    }
}