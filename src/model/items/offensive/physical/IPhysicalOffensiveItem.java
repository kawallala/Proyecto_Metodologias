package model.items.offensive.physical;

import model.items.offensive.IOffensiveItem;

/**
 * This interface represents the <i>Phisical Offensive items</i> that the units of the game can use
 * <p>
 * The signature for all the common methods of Physical Offensive Items are defined here.
 * All Physical Offensive Items are weak against Magic Offensive Items, and weak or strong against other Physical
 * Offensive Items
 *
 * @author Martin Araya Zavala
 * @since 1.22
 */
public interface IPhysicalOffensiveItem extends IOffensiveItem {
    /**
     * Calculates the damage after being blocked by an Axe
     *
     * @param axe The axe that's being used for defense
     */
    void defendedByAxe(Axe axe);

    /**
     * @param spear the
     */
    void defendedBySpear(Spear spear);

    void defendedBySword(Sword sword);
}
