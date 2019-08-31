package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        hero = new Hero(50, 2, field.getCell(0, 0));
        hero.addToInventory(spear);
        spear.equipTo(hero);
    }


    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return hero;
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

    @Override
    public void testAttackTargetHero() {

    }
}