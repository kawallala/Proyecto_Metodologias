package model.factories.item;

import org.junit.jupiter.api.BeforeEach;

public class SwordFactoryTest extends AbstractEquipableItemFactoryTest{
  @BeforeEach
  public void setUp(){
    factory = new SwordFactory();
    name = "Sword";
  }
}
