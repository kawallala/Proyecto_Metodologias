package model.factories.item;

import org.junit.jupiter.api.BeforeEach;

public class LightMagicBookFactoryTest extends AbstractEquipableItemFactoryTest {
  @BeforeEach
  public void setUp(){
    factory = new LightMagicBookFactory();
    name = "Light Magic Book";
  }
}
