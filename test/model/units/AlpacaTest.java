package model.units;

import org.junit.jupiter.api.Test;

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
        alpaca = new Alpaca(50, 2, field.getCell(0, 0));
    }


    @Override
    public Alpaca getTestUnit() {
        return alpaca;
    }


    /**
     * Test does nothing since the ALpaca cannot attack
     */
    @Override
    @Test
    public void testAttackTargetAlpaca() {

    }

    /**
     * Test does nothing since the Alpaca cannot attack
     */
    @Test
    @Override
    public void testAttackTargetArcher() {

    }

    /**
     * Test does nothing since the Alpaca cannot attack
     */
    @Test
    @Override
    public void testAttackTargetCleric() {

    }
}