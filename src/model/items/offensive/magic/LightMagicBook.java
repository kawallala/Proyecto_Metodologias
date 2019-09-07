package model.items.offensive.magic;

public class LightMagicBook extends AbstractMagicOffensiveItem {
    /**
     * Constructor for a light magic book.
     *
     * A light magic book is strong against dark magic books and weak
     * against anima magic books
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public LightMagicBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void ownerAttackedByMagicOffensiveItem(IMagicOffensiveItem magicOffensiveItem) {
        magicOffensiveItem.defendedByLightMagicBook(this);
    }

    @Override
    public void defendedByLightMagicBook(LightMagicBook lightMagicBook) {
        lightMagicBook.ownerAttackedByLightMagicBook(this);
    }

    @Override
    public void defendedByDarkMagicBook(DarkMagicBook darkMagicBook) {
        darkMagicBook.ownerAttackedByLightMagicBook(this);
    }

    @Override
    public void defendedByAnimaMagicBook(AnimaMagicBook animaMagicBook) {
        animaMagicBook.ownerAttackedByLightMagicBook(this);
    }
}
