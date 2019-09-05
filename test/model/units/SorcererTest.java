package model.units;

import static org.junit.jupiter.api.Assertions.*;

class SorcererTest extends AbstractTestUnit {

    private Sorcerer sorcerer;

    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(100, 2, getField().getCell(0, 0));
    }

    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    @Override
    public void testAttackTargetFighter() {

    }

    @Override
    public void testAttackTargetHero() {

    }

    @Override
    public void testAttackTargetSwordMaster() {

    }

    @Override
    public void testAttackTargetSorcerer() {

    }
}