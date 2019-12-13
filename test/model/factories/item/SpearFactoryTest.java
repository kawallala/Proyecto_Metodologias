package model.factories.item;

import org.junit.jupiter.api.BeforeEach;

public class SpearFactoryTest extends AbstractEquipableItemFactoryTest {
  @BeforeEach
  public void setUp(){
    factory = new SpearFactory();
    name = "Spear";
  }
}
