package model.factories.unit;

import org.junit.jupiter.api.Test;

/**
 * Class that defines the behaviour for the tests for factories that produce units
 *
 * @author Martin Araya Zavala
 * @since 2.15
 */
public interface IUnitFactoryTest {

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
   * Checks that a location is set properly
   */
  @Test
  void setLocationTest();

  /**
   * Checks that the maximum hit points are set properly
   */
  @Test
  void setHitPointsTest();

  /**
   * Checks that the movement is set properly
   */
  @Test
  void setMovementTest();
}
