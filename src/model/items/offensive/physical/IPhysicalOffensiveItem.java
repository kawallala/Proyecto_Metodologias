package model.items.offensive.physical;

import model.items.offensive.IOffensiveItem;

/**
 * @author Martin Araya Zavala
 * @since 1.22
 */
public interface IPhysicalOffensiveItem extends IOffensiveItem {
    void defendedByAxe(Axe axe);

    void defendedBySpear(Spear spear);

    void defendedBySword(Sword sword);
}
