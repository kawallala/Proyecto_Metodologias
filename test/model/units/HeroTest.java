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
    public void testAttackTargetFighter() {
        hero.addToInventory(spear);
        spear.equipTo(hero);

        targetFighter.addToInventory(axe);
        axe.equipTo(targetFighter);

        //in range
        targetFighter.moveTo(field.getCell(0, 1));
        assertEquals(50, targetFighter.getCurrentHitPoints());
        hero.attack(targetFighter);
        assertEquals(50, targetFighter.getCurrentHitPoints());
        assertEquals(35, hero.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetFighter.moveTo(field.getCell(2, 2));
        hero.attack(targetFighter);
        assertEquals(50, targetFighter.getCurrentHitPoints());
        assertEquals(35, hero.getCurrentHitPoints());
    }
    @Test
    @Override
    public void testAttackTargetHero() {
        hero.addToInventory(spear);
        spear.equipTo(hero);
        Spear secondspear = new Spear("second spear", 25, 1, 2);
        targetHero.addToInventory(secondspear);
        secondspear.equipTo(targetHero);

        //in range
        targetHero.moveTo(field.getCell(0, 1));
        assertEquals(100, targetHero.getCurrentHitPoints());
        hero.attack(targetHero);
        assertEquals(75, targetHero.getCurrentHitPoints());
        assertEquals(75, hero.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetHero.moveTo(field.getCell(2, 2));
        hero.attack(targetHero);
        assertEquals(75, targetHero.getCurrentHitPoints());
        assertEquals(75, hero.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testAttackTargetSwordMaster() {
        hero.addToInventory(spear);
        spear.equipTo(hero);

        targetSwordMaster.addToInventory(sword);
        sword.equipTo(targetSwordMaster);

        //in range
        targetSwordMaster.moveTo(field.getCell(0, 1));
        assertEquals(50, targetSwordMaster.getCurrentHitPoints());
        hero.attack(targetSwordMaster);
        assertEquals(35, targetSwordMaster.getCurrentHitPoints());
        assertEquals(50, hero.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSwordMaster.moveTo(field.getCell(2, 2));
        hero.attack(targetSwordMaster);
        assertEquals(35, targetSwordMaster.getCurrentHitPoints());
        assertEquals(50, hero.getCurrentHitPoints());
    }

    @Override
    public void testAttackTargetSorcerer() {

    }
}