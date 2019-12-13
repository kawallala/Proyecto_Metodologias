package model.factories.item;

import org.junit.jupiter.api.BeforeEach;

/**
 * This class represents the test for a Axe factory
 *
 * @author Martin Araya Zavala
 * @since 2.18
 */
public class AxeFactoryTest extends AbstractEquipableItemFactoryTest {
  @BeforeEach
  public void setUp() {
    factory = new AxeFactory();
    name = "Axe";
  }
}