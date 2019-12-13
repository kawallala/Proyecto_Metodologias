package model.factories.item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents the tests for a bow factory
 *
 * @author Martin Araya Zavala
 * @since 2.18
 */
public class BowFactoryTest extends AbstractEquipableItemFactoryTest {
  @BeforeEach
  public void setUp(){
    factory = new BowFactory();
    name = "Bow";
  }

  /**
   * Checks that the create method works properly, a bow has minimum range of 2
   */
  @Override
  @Test
  public void createTest() {
    item = factory.create();
    Assertions.assertEquals(name, item.getName());
    Assertions.assertEquals(25, item.getPower());
    Assertions.assertEquals(2, item.getMinRange());
    Assertions.assertEquals(3, item.getMaxRange());
  }

  /**
   * Checks that the default parameters are applied, a bow has a minimum range of 2
   */
  @Override
  @Test
  public void setDefaultsTest() {
    factory.setName("armita");
    factory.setMaximumRange(100);
    factory.setMinimumRange(50);
    factory.setPower(5000);
    factory.setDefaults();
    item = factory.create();
    Assertions.assertEquals(name, item.getName());
    Assertions.assertEquals(25, item.getPower());
    Assertions.assertEquals(2, item.getMinRange());
    Assertions.assertEquals(3, item.getMaxRange());
  }

  /**
   * Checks that a minimum range can be set, a bow can have a minimum range of 2
   */
  @Override
  @Test
  public void setMinimumRangeTest() {
    factory.setMinimumRange(1);
    item = factory.create();
    Assertions.assertEquals(2, item.getMinRange());
    factory.setMinimumRange(2);
    item = factory.create();
    Assertions.assertEquals(2, item.getMinRange());
    factory.setMinimumRange(100);
    item = factory.create();
    Assertions.assertEquals(100, item.getMinRange());
    Assertions.assertEquals(100, item.getMaxRange());
  }
}
