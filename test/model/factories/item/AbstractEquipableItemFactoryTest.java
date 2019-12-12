package model.factories.item;

import model.items.IEquipableItem;
import org.junit.jupiter.api.Assertions;

/**
 * This class represents an Abstract test
 * <p>
 * The common behaviour of the tests are defined here
 */
public class AbstractEquipableItemFactoryTest implements IEquipableItemFactoryTest {
  private IEquipableItemFactory factory;
  private IEquipableItem item;
  @Override
  public void createTest() {
  }

  @Override
  public void setDefaultsTest() {

  }

  @Override
  public void setNameTest() {

  }

  @Override
  public void setPowerTest() {
    factory.setPower(200);
    item = factory.create();
    Assertions.assertEquals(200, item.getPower());
  }

  @Override
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
  public void setMaximumRangeTest() {
    factory.setMaximumRange(4);
    item = factory.create();
    Assertions.assertEquals(4,item.getMaxRange());
  }
}
