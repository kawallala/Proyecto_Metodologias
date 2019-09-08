package model.items.offensive.magic;

public class DarkMagicBook extends AbstractMagicOffensiveItem {
    /**
     * Constructor for a Dark Magic Book.
     *
     * A Dark Magic Book is strong against Anima Magic Books and weak
     * against Light Magic Books
     *
     * @param name     the name of the Dark Magic Book
     * @param power    the offensive power of the Dark Magic Book
     * @param minRange the minimum range of the Dark Magic Book
     * @param maxRange the maximum range of the Dark Magic Book
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
