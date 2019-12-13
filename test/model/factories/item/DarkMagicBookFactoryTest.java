package model.factories.item;

import org.junit.jupiter.api.BeforeEach;

/**
 * This class represents the tests for a Dark Magic Book Factory
 *
 * @author Martin Araya Zavala
 * @since 2.18
 */
public class DarkMagicBookFactoryTest extends AbstractEquipableItemFactoryTest {
  @BeforeEach
  public void setUp(){
    factory = new DarkMagicBookFactory();
    name = "Dark Magic Book";
  }
}
