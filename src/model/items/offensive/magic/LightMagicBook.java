package model.items.offensive.magic;

public class LightMagicBook extends AbstractMagicOffensiveItem {
    /**
     * Constructor for a Light Magic Book.
     *
     * A Light Magic Book is strong against Dark Magic Books and weak
     * against Anima Magic Books
     *
     * @param name     the name of the Light Magic Book
     * @param power    the offensive power of the Light Magic Book
     * @param minRange the minimum range of the Light Magic Book
     * @param maxRange the maximum range of the Light Magic Book
     */
    public LightMagicBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    /**
     * Defends the owner of the Light Magic Book by using it
     *
     * @param magicOffensiveItem the Magic Offensive Item that is dealing the damage
     */
    @Override
    public void ownerAttackedByMagicOffensiveItem(IMagicOffensiveItem magicOffensiveItem) {
        magicOffensiveItem.defendedByLightMagicBook(this);
    }

    @Override
    public void defendedByLightMagicBook(LightMagicBook lightMagicBook) {
        lightMagicBook.getOwner().normalDamage(this.getPower());
    }

    @Override
    public void defendedByDarkMagicBook(DarkMagicBook darkMagicBook) {
        darkMagicBook.getOwner().strongDamage(this.getPower());
    }

    @Override
    public void defendedByAnimaMagicBook(AnimaMagicBook animaMagicBook) {
        animaMagicBook.getOwner().weakDamage(this.getPower());
    }
}
