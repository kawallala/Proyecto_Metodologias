package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.IEquipableItem;
import model.items.offensive.physical.Spear;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class HeroTest extends AbstractTestUnit {

    private Hero hero;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        hero = new Hero(100, 2, field.getCell(0, 0));

    }


    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return hero;
    }

    @Override
    public IEquipableItem getCorrespondingWeapon() {
        return spear;
    }

    @Override
    @Test
    public void equipSpearTest() {
        assertNull(hero.getEquippedItem());
        hero.addToInventory(getSpear());
        this.spear.equipTo(this.hero);
        assertEquals(spear, hero.getEquippedItem());
    }

    @Test
    @Override
    public void testCombatTargetFighter() {
        hero.addToInventory(spear);
        hero.equip(spear);

        targetFighter.addToInventory(axe);
        targetFighter.equip(axe);

        //in range
        targetFighter.moveTo(field.getCell(0, 1));
        assertEquals(100, targetFighter.getCurrentHitPoints());
        hero.beginCombat(targetFighter);
        assertEquals(95, targetFighter.getCurrentHitPoints());
        assertEquals(62, hero.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetFighter.moveTo(field.getCell(2, 2));
        hero.beginCombat(targetFighter);
        assertEquals(95, targetFighter.getCurrentHitPoints());
        assertEquals(62, hero.getCurrentHitPoints());
    }
    @Test
    @Override
    public void testCombatTargetHero() {
        hero.addToInventory(spear);
        hero.equip(spear);

        Spear secondSpear = new Spear("second spear", 25, 1, 2);
        targetHero.addToInventory(secondSpear);
        targetHero.equip(secondSpear);

        //in range
        targetHero.moveTo(field.getCell(0, 1));
        assertEquals(100, targetHero.getCurrentHitPoints());
        hero.beginCombat(targetHero);
        assertEquals(75, targetHero.getCurrentHitPoints());
        assertEquals(75, hero.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetHero.moveTo(field.getCell(2, 2));
        hero.beginCombat(targetHero);
        assertEquals(75, targetHero.getCurrentHitPoints());
        assertEquals(75, hero.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetSwordMaster() {
        hero.addToInventory(spear);
        hero.equip(spear);

        targetSwordMaster.addToInventory(sword);
        targetSwordMaster.equip(sword);

        //in range
        targetSwordMaster.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSwordMaster.getCurrentHitPoints());
        hero.beginCombat(targetSwordMaster);
        assertEquals(62, targetSwordMaster.getCurrentHitPoints());
        assertEquals(95, hero.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSwordMaster.moveTo(field.getCell(2, 2));
        hero.beginCombat(targetSwordMaster);
        assertEquals(62, targetSwordMaster.getCurrentHitPoints());
        assertEquals(95, hero.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetSorcerer() {
        hero.addToInventory(spear);
        hero.equip(spear);

        targetSorcerer.addToInventory(animaMagicBook);
        targetSorcerer.equip(animaMagicBook);

        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        hero.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, hero.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        hero.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, hero.getCurrentHitPoints());
    }
}