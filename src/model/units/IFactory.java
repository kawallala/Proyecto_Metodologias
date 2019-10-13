package model.units;

import model.items.IEquipableItem;
import model.map.Location;

public interface IFactory {
    public void setHitpoints(int hitpoints);
    public void setMovement(int movement);
    public void setLocation(Location location);
    public Alpaca createAlpaca();
    public Archer createArcher();
    public Cleric createCleric();
    public Fighter createFighter();
    public Hero createHero();
    public Sorcerer createSorcerer();
    public SwordMaster createSwordMaster();
}
