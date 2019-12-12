package model.factories.item;

import model.items.IEquipableItem;
import org.junit.jupiter.api.Assertions;

/**
 * This class represents an Abstract test
 *
 * The common behaviour of the tests are defined here
 */
public class AbstractEquipableItemFactoryTest implements IEquipableItemFactoryTest {
  private IEquipableItemFactory factory;

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
    IEquipableItem item = factory.create();
    Assertions.assertEquals(200, item.getPower());
  }

  @Override
  public void setMinimumRangeTest() {
    factory.setMinimumRange();
  }

  @Override
  public void setMaximumRangeTest() {

  }
}
