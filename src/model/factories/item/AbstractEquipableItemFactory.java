package model.factories.item;

/**
 * This class represents the abstract behaviour for an item creating factory
 * <p>
 * There is a default value for all the parameters an item can be created with, this parameters can be changed for
 * personalization
 *
 * @author Martin Araya
 * @since 2.8
 */
public abstract class AbstractEquipableItemFactory implements IEquipableItemFactory {
  private String name;
  private int power;
  private int minimumRange;
  private int maximumRange;

  /**
   * Creates an Item Factory with the default values
   */
  public AbstractEquipableItemFactory() {
    this.setDefaults();
  }

  /**
   * Getter for the name stored in the factory
   *
   * @return The stored name
   */
  protected String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for the power stored in the factory
   *
   * @return the stored power
   */
  protected int getPower() {
    return power;
  }

  @Override
  public void setPower(int power) {
    this.power = power;
  }

  /**
   * Getter for the minimum range stored in the factory
   *
   * @return the stored minimum range
   */
  protected int getMinimumRange() {
    return minimumRange;
  }

  @Override
  public void setMinimumRange(int minimumRange) {
    this.minimumRange = minimumRange;
    this.maximumRange = Math.max(minimumRange, this.maximumRange);
  }

  /**
   * Getter for the maximum range stored in the factory
   *
   * @return the stored maximum range
   */
  protected int getMaximumRange() {
    return maximumRange;
  }

  @Override
  public void setMaximumRange(int maximumRange) {
    this.maximumRange = Math.max(maximumRange, this.minimumRange);
  }
}
