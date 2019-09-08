package model.items.offensive.magic;

public class AnimaMagicBook extends AbstractMagicOffensiveItem {
    /**
     * Constructor for a Anima Magic Book.
     *
     * A Anima Magic Book is strong against light magic books and weak
     * against dark magic books
     *
     * @param name     the name of the Anima Magic Book
     * @param power    the offensive power of the Anima Magic Book
     * @param minRange the minimum range of the Anima Magic Book
     * @param maxRange the maximum range of the Anima Magic Book
     */
    public AnimaMagicBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void ownerAttackedByMagicOffensiveItem(IMagicOffensiveItem magicOffensiveItem) {
        magicOffensiveItem.defendedByAnimaMagicBook(this);
    }

    @Override
    public void defendedByLightMagicBook(LightMagicBook lightMagicBook) {
        lightMagicBook.getOwner().strongDamage(this.getPower());
    }

    @Override
    public void defendedByDarkMagicBook(DarkMagicBook darkMagicBook) {
        darkMagicBook.getOwner().weakDamage(this.getPower());
    }

    @Override
    public void defendedByAnimaMagicBook(AnimaMagicBook animaMagicBook) {
        animaMagicBook.getOwner().normalDamage(this.getPower());
    }

}
