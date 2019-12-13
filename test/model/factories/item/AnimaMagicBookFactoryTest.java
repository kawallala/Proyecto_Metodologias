package model.factories.item;

import org.junit.jupiter.api.BeforeEach;

/**
 * This class represents the tests for the Anima Magic Book Factory
 *
 * @author Martin Araya Zavala
 * @since 2.19
 */
public class AnimaMagicBookFactoryTest extends AbstractEquipableItemFactoryTest {
  @BeforeEach
  public void setUp() {
    factory = new AnimaMagicBookFactory();
    name = "Anima Magic Book";
  }

}
