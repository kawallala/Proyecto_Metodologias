package model.items;

public interface IMagicBook extends IEquipableItem{

    /**
     * defends the owner with a light magic book
     * @param lightMagicBook
     *      the light magic book that's being used for defense
     */
    void defendedByLightMagicBook(LightMagicBook lightMagicBook);

    /**
     * Calculates the type of damage to the owner of this magic book
     * @param lightMagicBook
     *      the light magic book that is dealing the damage
     */
    void ownerAttackedByLightMagicBook(LightMagicBook lightMagicBook);

    /**
     * defends the owner with a dark magic book
     * @param darkMagicBook
     *      the dark magic book that's being used for defense
     */
    void defendedByDarkMagicBook(DarkMagicBook darkMagicBook);

    /**
     * Calculates the type of damage to the owner of this magic Book
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
     * Calculates the type of damage to the owner of this magic book
     * @param animaMagicBook
     *      the anima magic book that is dealing the damage
     */
    void ownerAttackedByAnimaMagicBook(AnimaMagicBook animaMagicBook);
}
