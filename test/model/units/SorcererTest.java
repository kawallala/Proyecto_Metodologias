package model.units;

import model.items.IEquipableItem;
import model.items.offensive.magic.AnimaMagicBook;
import model.items.offensive.magic.DarkMagicBook;
import model.items.offensive.magic.IMagicOffensiveItem;
import model.items.offensive.magic.LightMagicBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorcererTest extends AbstractTestUnit {

    private Sorcerer sorcerer;

    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(100, 2, getField().getCell(0, 0));
    }

    @Override
    public IEquipableItem getCorrespondingWeapon() {
        return animaMagicBook;
    }

    @Override
    @Test
    public void equipIMagicOffensiveItem() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addToInventory(animaMagicBook);
        sorcerer.addToInventory(darkMagicBook);
        sorcerer.addToInventory(lightMagicBook);
        sorcerer.equip(animaMagicBook);
        assertEquals(animaMagicBook,sorcerer.getEquippedItem());
        sorcerer.unequip();
        sorcerer.equip(lightMagicBook);
        assertEquals(lightMagicBook,sorcerer.getEquippedItem());
        sorcerer.unequip();
        sorcerer.equip(darkMagicBook);
        assertEquals(darkMagicBook,sorcerer.getEquippedItem());
        sorcerer.unequip();

    }

    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    @Override
    @Test
    public void testCombatTargetArcher() {
        getTestUnit().addToInventory(getCorrespondingWeapon());
        getCorrespondingWeapon().equipTo(getTestUnit());

        targetArcher.addToInventory(bow);
        bow.equipTo(targetArcher);

        //in range, no counter attack
        targetArcher.moveTo(field.getCell(0, 1));
        assertEquals(100, targetArcher.getCurrentHitPoints());
        getTestUnit().beginCombat(targetArcher);
        assertEquals(62, targetArcher.getCurrentHitPoints());
        assertEquals(100, getTestUnit().getCurrentHitPoints());

        //in range
        targetArcher.moveTo(field.getCell(0, 2));
        getTestUnit().beginCombat(targetArcher);
        assertEquals(24, targetArcher.getCurrentHitPoints());
        assertEquals(62, getTestUnit().getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0, 1));
        targetArcher.moveTo(field.getCell(2, 2));
        getTestUnit().beginCombat(targetArcher);
        assertEquals(24, targetArcher.getCurrentHitPoints());
        assertEquals(62, getTestUnit().getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetCleric() {
        getTestUnit().addToInventory(getCorrespondingWeapon());
        getCorrespondingWeapon().equipTo(getTestUnit());

        targetCleric.addToInventory(staff);
        staff.equipTo(targetCleric);

        //in range
        targetCleric.moveTo(field.getCell(0, 1));
        assertEquals(100, targetCleric.getCurrentHitPoints());
        getTestUnit().beginCombat(targetCleric);
        assertEquals(62, targetCleric.getCurrentHitPoints());
        assertEquals(100, getTestUnit().getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0, 2));
        targetCleric.moveTo(field.getCell(2, 2));
        getTestUnit().beginCombat(targetCleric);
        assertEquals(62, targetCleric.getCurrentHitPoints());
        assertEquals(100, getTestUnit().getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetFighter() {
        sorcerer.addToInventory(animaMagicBook);
        sorcerer.equip(animaMagicBook);

        targetFighter.addToInventory(axe);
        targetFighter.equip(axe);

        //in range
        targetFighter.moveTo(field.getCell(0, 1));
        assertEquals(100, targetFighter.getCurrentHitPoints());
        sorcerer.beginCombat(targetFighter);
        assertEquals(62, targetFighter.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetFighter.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetFighter);
        assertEquals(62, targetFighter.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetHero() {
        sorcerer.addToInventory(animaMagicBook);
        sorcerer.equip(animaMagicBook);

        targetHero.addToInventory(spear);
        targetHero.equip(spear);

        //in range
        targetHero.moveTo(field.getCell(0, 1));
        assertEquals(100, targetHero.getCurrentHitPoints());
        sorcerer.beginCombat(targetHero);
        assertEquals(62, targetHero.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetHero.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetHero);
        assertEquals(62, targetHero.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetSwordMaster() {
        sorcerer.addToInventory(animaMagicBook);
        sorcerer.equip(animaMagicBook);

        targetSwordMaster.addToInventory(sword);
        targetSwordMaster.equip(sword);

        //in range
        targetSwordMaster.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSwordMaster.getCurrentHitPoints());
        sorcerer.beginCombat(targetSwordMaster);
        assertEquals(62, targetSwordMaster.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSwordMaster.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetSwordMaster);
        assertEquals(62, targetSwordMaster.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());
    }

    @Override
    @Test
    public void testCombatTargetSorcerer() {
        sorcerer.addToInventory(animaMagicBook);
        sorcerer.equip(animaMagicBook);

        targetSorcerer.addToInventory(darkMagicBook);
        targetSorcerer.equip(darkMagicBook);

        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(95, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(95, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());

        sorcerer.heal(100);
        targetSorcerer.heal(100);

        targetSorcerer.addToInventory(lightMagicBook);
        targetSorcerer.equip(lightMagicBook);
        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(95, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(95, sorcerer.getCurrentHitPoints());

        sorcerer.heal(100);
        targetSorcerer.heal(100);
        IMagicOffensiveItem secondBook = new AnimaMagicBook("second book",25,1,2);

        targetSorcerer.addToInventory(secondBook);
        targetSorcerer.equip(secondBook);
        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(75, targetSorcerer.getCurrentHitPoints());
        assertEquals(75, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(75, targetSorcerer.getCurrentHitPoints());
        assertEquals(75, sorcerer.getCurrentHitPoints());
    }
    @Test
    public void TestCombatTargetSorcererDark(){
        sorcerer.addToInventory(darkMagicBook);
        sorcerer.equip(darkMagicBook);

        targetSorcerer.addToInventory(lightMagicBook);
        targetSorcerer.equip(lightMagicBook);

        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(95, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(95, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());

        sorcerer.heal(100);
        targetSorcerer.heal(100);

        targetSorcerer.addToInventory(animaMagicBook);
        targetSorcerer.equip(animaMagicBook);
        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(95, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(95, sorcerer.getCurrentHitPoints());

        sorcerer.heal(100);
        targetSorcerer.heal(100);
        IMagicOffensiveItem secondBook = new DarkMagicBook("second book",25,1,2);

        targetSorcerer.addToInventory(secondBook);
        targetSorcerer.equip(secondBook);
        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(75, targetSorcerer.getCurrentHitPoints());
        assertEquals(75, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(75, targetSorcerer.getCurrentHitPoints());
        assertEquals(75, sorcerer.getCurrentHitPoints());
    }
    @Test
    public void TestCombatTargetSorcererLight(){
        sorcerer.addToInventory(lightMagicBook);
        sorcerer.equip(lightMagicBook);

        targetSorcerer.addToInventory(animaMagicBook);
        targetSorcerer.equip(animaMagicBook);

        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(95, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(95, targetSorcerer.getCurrentHitPoints());
        assertEquals(62, sorcerer.getCurrentHitPoints());

        sorcerer.heal(100);
        targetSorcerer.heal(100);

        targetSorcerer.addToInventory(darkMagicBook);
        targetSorcerer.equip(darkMagicBook);
        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(95, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(62, targetSorcerer.getCurrentHitPoints());
        assertEquals(95, sorcerer.getCurrentHitPoints());

        sorcerer.heal(100);
        targetSorcerer.heal(100);
        IMagicOffensiveItem secondBook = new LightMagicBook("second book",25,1,2);

        targetSorcerer.addToInventory(secondBook);
        targetSorcerer.equip(secondBook);
        //in range
        targetSorcerer.moveTo(field.getCell(0, 1));
        assertEquals(100, targetSorcerer.getCurrentHitPoints());
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(75, targetSorcerer.getCurrentHitPoints());
        assertEquals(75, sorcerer.getCurrentHitPoints());

        //out of range
        targetAlpaca.moveTo(field.getCell(0,2));
        targetSorcerer.moveTo(field.getCell(2, 2));
        sorcerer.beginCombat(targetSorcerer);
        assertEquals(75, targetSorcerer.getCurrentHitPoints());
        assertEquals(75, sorcerer.getCurrentHitPoints());
    }
}