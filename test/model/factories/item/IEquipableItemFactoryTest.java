package model.factories.item;

import org.junit.jupiter.api.Test;

/**
 * Class that defines the behaviour for the tests for factories that produce items
 *
 * @author Martin Araya Zavala
 * @since 2.15
 */
public interface IEquipableItemFactoryTest {
  /**
   * Sets the states necesarry for the tests to function
   */
  void setUp();
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

  /**
   * Checks that a name can be set
   */
  @Test
  void setNameTest();

  /**
   * Checks that a power can be set
   */
  @Test
  void setPowerTest();

  /**
   * Checks that a minimum range can be set
   */
  @Test
  void setMinimumRangeTest();

  /**
   * Checks that a maximum range can be set
   */
  @Test
  void setMaximumRangeTest();
}