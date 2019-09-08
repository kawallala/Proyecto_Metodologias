package model.items.offensive.magic;

import model.items.offensive.IOffensiveItem;
import model.items.offensive.physical.IPhysicalOffensiveItem;

/**
 * This interface represents the <i>Magic Offensive items</i> that the units of the game can use
 * <p>
 * The signature for all the common methods of Magic Offensive Items are defined here.
 * All Magic Offensive Items are weak against Physical Offensive Items, and weak or strong against other
 * Magic Offensive Items
 *
 * @author Martin Araya Zavala
 * @since 1.22
 */
public interface IMagicOffensiveItem extends IOffensiveItem {
    /**
     * Deals strong damage to the owner of the item since Magic Offensive Items are Weak to Physical Offensive Items
     *
     * @param physicalOffensiveItem the physical offensive item that is dealing the damage
     */
    @Override
    void ownerAttackedByPhysicalOffensiveItem(IPhysicalOffensiveItem physicalOffensiveItem);

    /**
     * Calculates the damage after being blocked by a Light Magic Book
     *
     * @param lightMagicBook the Light Magic Book that's being used for defense
     */
    void defendedByLightMagicBook(LightMagicBook lightMagicBook);

    /**
     * Calculates the damage after being blocked by a Dark Magic Book
     *
     * @param darkMagicBook the Dark Magic Book that's being used for defense
     */
    void defendedByDarkMagicBook(DarkMagicBook darkMagicBook);

    /**
     * Calculates the damage after being blocked by a Anima Magic Book
     *
     * @param animaMagicBook the anima magic book that's being used for defense
     */
    void defendedByAnimaMagicBook(AnimaMagicBook animaMagicBook);
}
