package model.factories.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AlpacaFactoryTest extends AbstractUnitFactoryTest {
  @BeforeEach
  @Override
  public void setUp() {
    super.setUp();
    factory = new AlpacaFactory();
  }

  @Override
  @Test
  public void createTest() {
    unit = factory.create();
    Assertions.assertEquals(100, unit.getCurrentHitPoints());
    Assertions.assertEquals(new ArrayList<>(), unit.getItems());
    Assertions.assertEquals(2, unit.getMovement());
    Assertions.assertEquals(location, unit.getLocation());
    Assertions.assertNull(unit.getEquippedItem());
    Assertions.assertEquals(Integer.MAX_VALUE, unit.getMaximumItems());
  }
}
