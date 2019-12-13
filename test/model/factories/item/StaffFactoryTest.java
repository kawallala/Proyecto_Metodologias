package model.factories.item;

import org.junit.jupiter.api.BeforeEach;

public class StaffFactoryTest extends AbstractEquipableItemFactoryTest {
  @BeforeEach
  public void setUp(){
    factory = new StaffFactory();
    name = "Staff";
  }
}
