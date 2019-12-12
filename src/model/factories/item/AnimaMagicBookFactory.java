package model.factories.item;

import model.items.offensive.magic.AnimaMagicBook;

/**
 * This class represents a Anima Magic Book crating Factory
 *
 * @author Martin Araya
 * @since 2.8
 */
public class AnimaMagicBookFactory extends AbstractEquipableItemFactory {

  /**
   * Sets the default parameters for an Anima Magic Book to be created with
   */
  @Override
  public void setDefaults() {
    setName("Anima Magic Book");
    setPower(25);
    setMinimumRange(1);
    setMaximumRange(2);
  }

  /**
   * Creates a new Anima Magic Book with the parameters stored in the class
   *
   * @return the newly created Anima Magic Book
   */
  @Override
  public AnimaMagicBook create() {
    AnimaMagicBook item = new AnimaMagicBook(this.getName(), this.getPower(), this.getMinimumRange(), this.getMaximumRange());
    setDefaults();
    return item;
  }
}
