package model.units;

import model.items.IEquipableItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test set for the alpaca unit
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {

    private Alpaca alpaca;

    @Override
    public void setTestUnit() {
        alpaca = new Alpaca(100, 2, field.getCell(0, 0));
    }


    @Override
    public Alpaca getTestUnit() {
        return alpaca;
    }

    @Override
    @Test
    public void deadUnitTest() {
        alpaca.strongDamage(200);
        assertEquals(0, alpaca.getCurrentHitPoints());
        alpaca.moveTo(getField().getCell(0,2));
        assertNull(getField().getCell(0,2).getUnit());
        assertEquals(alpaca, getField().getCell(0,0).getUnit());

        targetAlpaca.moveTo(getField().getCell(0,1));
        assertEquals(100, targetAlpaca.getCurrentHitPoints());
        alpaca.beginCombat(targetAlpaca);
        assertEquals(100, targetAlpaca.getCurrentHitPoints());
        assertEquals(0, alpaca.getCurrentHitPoints());
    }

    private void nulldamageAlpaca(IUnit targetUnit, IEquipableItem targetItem){
        targetUnit.addToInventory(targetItem);
        targetItem.equipTo(targetUnit);

        targetUnit.moveTo(getField().getCell(0,1));
        assertEquals(100, targetUnit.getCurrentHitPoints());
        alpaca.beginCombat(targetUnit);
        assertEquals(100, targetUnit.getCurrentHitPoints());
        assertEquals(100, alpaca.getCurrentHitPoints());
    }
    /**
     * Test does nothing since the ALpaca cannot attack
     */
    @Override
    @Test
    public void testCombatTargetAlpaca() {
        targetAlpaca.moveTo(getField().getCell(0,1));
        assertEquals(100, targetAlpaca.getCurrentHitPoints());
        alpaca.beginCombat(targetAlpaca);
        assertEquals(100, targetAlpaca.getCurrentHitPoints());
        assertEquals(100, alpaca.getCurrentHitPoints());
    }

    /**
     * Test does nothing since the Alpaca cannot attack
     */
    @Test
    @Override
    public void testCombatTargetArcher() {
        nulldamageAlpaca(targetArcher, bow);
    }

    /**
     * Test does nothing since the Alpaca cannot attack
     */
    @Test
    @Override
    public void testCombatTargetCleric() {
        nulldamageAlpaca(targetCleric, staff);
    }

    /**
     * Test does nothing since the Alpaca cannot attack
     */
    @Test
    @Override
    public void testCombatTargetFighter() {
        nulldamageAlpaca(targetFighter, axe);
    }

    /**
     * Test does nothing since the Alpaca cannot attack
     */
    @Test
    @Override
    public void testCombatTargetHero() {
        nulldamageAlpaca(targetHero, spear);
    }

    /**
     * Test does nothing since the Alpaca cannot attack
     */
    @Override
    @Test
    public void testCombatTargetSwordMaster() {
        nulldamageAlpaca(targetSwordMaster, sword);
    }

    @Override
    @Test
    public void testCombatTargetSorcerer() {
        nulldamageAlpaca(targetSorcerer,animaMagicBook);
    }
}