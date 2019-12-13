package model.factories.unit;

import org.junit.jupiter.api.BeforeEach;

public class ArcherFactoryTest extends AbstractUnitFactoryTest {
  @Override
  @BeforeEach
  public void setUp() {
    super.setUp();
    factory = new ArcherFactory();
  }
}
