package model.items.offensive.magic;

import model.items.offensive.IOffensiveItem;

/**
 * This interface represent the <i>Magic Offensive items</i> that the units of the game can use
 * <p>
 * The signature for all the common methods of Magic Offensive Items is defined here.
 * All Magic Offensive Items are weak against Offensive Items
 *
 * @author Martin Araya Zavala
 * @since 1.22
 */
public interface IMagicOffensiveItem extends IOffensiveItem {
    /**
     * defends the owner with a light magic book
     *
     * @param lightMagicBook
     *      the light magic book that's being used for defense
     */
    void defendedByLightMagicBook(LightMagicBook lightMagicBook);

    /**
     * defends the owner with a dark magic book
     *
     * @param darkMagicBook
     *      the dark magic book that's being used for defense
     */
    void defendedByDarkMagicBook(DarkMagicBook darkMagicBook);

    /**
     * Defends the owner with a anima magic book
     * @param animaMagicBook
     *      the anima magic book that's beign used for defense
     */
    void defendedByAnimaMagicBook(AnimaMagicBook animaMagicBook);
}
