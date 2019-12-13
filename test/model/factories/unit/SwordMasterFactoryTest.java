package model.factories.unit;

import org.junit.jupiter.api.BeforeEach;

public class SwordMasterFactoryTest extends AbstractUnitFactoryTest {
  @BeforeEach
  @Override
  public void setUp() {
    super.setUp();
    factory = new SwordMasterFactory();
  }
}
