package model.items.offensive.magic;

public class AnimaMagicBook extends AbstractMagicOffensiveItem {
    /**
     * Constructor for a anima magic book.
     *
     * A anima magic book is strong against light magic books and weak
     * against dark magic books
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public AnimaMagicBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void ownerAttackedByMagicBook(IMagicOffensiveItem magicBook) {
        magicBook.defendedByAnimaMagicBook(this);
    }

    @Override
    public void ownerAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
        getOwner().weakDamage(lightMagicBook.getPower());
    }

    @Override
    public void ownerAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
        getOwner().strongDamage(darkMagicBook.getPower());
    }

    @Override
    public void defendedByLightMagicBook(LightMagicBook lightMagicBook) {
        lightMagicBook.ownerAttackedByAnimaMagicBook(this);
    }

    @Override
    public void defendedByDarkMagicBook(DarkMagicBook darkMagicBook) {
        darkMagicBook.ownerAttackedByAnimaMagicBook(this);
    }

    @Override
    public void defendedByAnimaMagicBook(AnimaMagicBook animaMagicBook) {
        animaMagicBook.ownerAttackedByAnimaMagicBook(this);
    }
}
