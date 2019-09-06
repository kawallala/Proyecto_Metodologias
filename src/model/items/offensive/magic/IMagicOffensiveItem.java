package model.items.offensive.magic;

import model.items.offensive.IOffensiveItem;

/**
 *
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
     * Deals normal damage to the owner of this magic book
     *
     * @param lightMagicBook
     *      the light magic book that is dealing the damage
     */
    void ownerAttackedByLightMagicBook(LightMagicBook lightMagicBook);

    /**
     * defends the owner with a dark magic book
     *
     * @param darkMagicBook
     *      the dark magic book that's being used for defense
     */
    void defendedByDarkMagicBook(DarkMagicBook darkMagicBook);

    /**
     * Deals normal damage to the owner of this magic Book
     * @param darkMagicBook
     *      the dark magic book that is dealing the damage
     */
    void ownerAttackedByDarkMagicBook(DarkMagicBook darkMagicBook);

    /**
     * Defends the owner with a anima magic book
     * @param animaMagicBook
     *      the anima magic book that's beign used for defense
     */
    void defendedByAnimaMagicBook(AnimaMagicBook animaMagicBook);

    /**
     * Deals normal damage to the owner of this magic book
     * @param animaMagicBook
     *      the anima magic book that is dealing the damage
     */
    void ownerAttackedByAnimaMagicBook(AnimaMagicBook animaMagicBook);
}
