package model.items.offensive.magic;

public class DarkMagicBook extends AbstractMagicOffensiveItem {
    /**
     * Constructor for a dark magic book.
     *
     * A dark magic book is strong agains anima magic books and weak
     * agains light magic books
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public DarkMagicBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void ownerAttackedByMagicOffensiveItem(IMagicOffensiveItem magicOffensiveItem) {
        magicOffensiveItem.defendedByDarkMagicBook(this);
    }

    @Override
    public void defendedByLightMagicBook(LightMagicBook lightMagicBook) {
        lightMagicBook.getOwner().weakDamage(this.getPower());
    }

    @Override
    public void defendedByDarkMagicBook(DarkMagicBook darkMagicBook) {
        darkMagicBook.getOwner().normalDamage(this.getPower());
    }

    @Override
    public void defendedByAnimaMagicBook(AnimaMagicBook animaMagicBook) {
        animaMagicBook.getOwner().strongDamage(this.getPower());

    }

}
