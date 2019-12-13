package model.factories.item;

import model.items.IEquipableItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class represents an Abstract test
 * <p>
 * The common behaviour of the tests are defined here
 */
public abstract class AbstractEquipableItemFactoryTest implements IEquipableItemFactoryTest {
  protected IEquipableItemFactory factory;
  protected IEquipableItem item;
  protected String name;

  @Override
  @Test
  public void createTest() {
    item = factory.create();
    Assertions.assertEquals(name, item.getName());
    Assertions.assertEquals(25, item.getPower());
    Assertions.assertEquals(1, item.getMinRange());
    Assertions.assertEquals(2, item.getMaxRange());
  }

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
    Assertions.assertEquals(1, item.getMinRange());
    Assertions.assertEquals(2, item.getMaxRange());
  }

  @Override
  @Test
  public void setNameTest() {
    factory.setName("armita");
    item = factory.create();
    Assertions.assertEquals("armita", item.getName());
  }

  @Override
  @Test
  public void setPowerTest() {
    factory.setPower(200);
    item = factory.create();
    Assertions.assertEquals(200, item.getPower());
  }

  @Override
  @Test
  public void setMinimumRangeTest() {
    factory.setMinimumRange(1);
    item = factory.create();
    Assertions.assertEquals(1, item.getMinRange());
    factory.setMinimumRange(100);
    item = factory.create();
    Assertions.assertEquals(100, item.getMinRange());
    Assertions.assertEquals(100, item.getMaxRange());
  }

  @Override
  @Test
  public void setMaximumRangeTest() {
    factory.setMaximumRange(4);
    item = factory.create();
    Assertions.assertEquals(4, item.getMaxRange());
  }
}
