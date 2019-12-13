package model.factories.unit;

import model.map.Location;
import model.units.IUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public abstract class AbstractUnitFactoryTest implements IUnitFactoryTest {
  protected IUnitFactory factory;
  protected Location location;
  protected IUnit unit;

  @BeforeEach
  public void setUp() {
    location = new Location(0, 0);
  }

  @Override
  @Test
  public void createTest() {
    unit = factory.create();
    Assertions.assertEquals(100, unit.getCurrentHitPoints());
    Assertions.assertEquals(new ArrayList<>(), unit.getItems());
    Assertions.assertEquals(2, unit.getMovement());
    Assertions.assertEquals(location, unit.getLocation());
    Assertions.assertNull(unit.getEquippedItem());
    Assertions.assertEquals(3, unit.getMaximumItems());
  }

  @Override
  @Test
  public void setDefaultsTest() {
    factory.setHitPoints(10000);
    factory.setLocation(new Location(2, 2));
    factory.setMovement(50);
    factory.setDefaults();
    unit = factory.create();
    Assertions.assertEquals(100, unit.getCurrentHitPoints());
    Assertions.assertEquals(new ArrayList<>(), unit.getItems());
    Assertions.assertEquals(2, unit.getMovement());
    Assertions.assertEquals(location, unit.getLocation());
    Assertions.assertNull(unit.getEquippedItem());
  }

  @Override
  @Test
  public void setLocationTest() {
    location = new Location(2,0);
    factory.setLocation(location);
    unit = factory.create();
    Assertions.assertEquals(location, unit.getLocation());
  }

  @Override
  @Test
  public void setHitPointsTest() {
    factory.setHitPoints(150);
    unit = factory.create();
    Assertions.assertEquals(150, unit.getCurrentHitPoints());
    Assertions.assertEquals(150, unit.getMaximumHitPoints());
  }

  @Override
  @Test
  public void setMovementTest() {
    factory.setMovement(5);
    unit = factory.create();
    Assertions.assertEquals(5, unit.getMovement());
  }
}
