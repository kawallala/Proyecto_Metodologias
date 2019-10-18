package model.tactician;

import model.map.Location;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Tactician {
    private String name;
    private ArrayList<IUnit> units = new ArrayList<IUnit>();
    private ArrayList<IUnit> unitsInGame = new ArrayList<IUnit>();
    private ArrayList<Location> unitLocations = new ArrayList<Location>();
    private PropertyChangeSupport changes;

    public Tactician(String name){
        this.name = name;
        changes = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    public void addUnit(IUnit unit){
        this.units.add(unit);
    }

    public void beginTurn() {

    }

    public List<IUnit> getUnits(){
        return this.units;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tactician){
            return this.getName().equals(((Tactician) obj).getName());
        }
        return false;
    }
}
