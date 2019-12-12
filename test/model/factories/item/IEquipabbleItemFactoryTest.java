package model.factories.item;

import model.units.AbstractTestUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class that defines the behaviour for the tests for factories that produce items
 *
 * @author Martin Araya Zavala
 * @since 2.15
 */
public interface IEquipabbleItemFactoryTest {

  /**
   * Checks that the create method works properly
   */
  @Test
  void createTest();

  /**
   * Checks that the default parameters are applied
   */
  @Test
  void setDefaultsTest();

  @Test
  void setNameTest();

  @Test
  void setPowerTest();

  @Test
  void setMinimumRangeTest();

  @Test
  void setMaximumRangeTest();
}