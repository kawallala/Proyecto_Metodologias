package model.tactician;

import model.map.Field;
import model.map.Location;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tactician {
    private String name;
    private ArrayList<IUnit> units = new ArrayList<IUnit>();
    private ArrayList<IUnit> unitsInGame = new ArrayList<IUnit>();
    private ArrayList<Integer> unitLocations = new ArrayList<Integer>();
    private PropertyChangeSupport changes;
    private Field gameMap;

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
        this.unitsInGame.addAll(this.units);
        for (int i = 0; i < unitsInGame.size(); i++) {
            unitsInGame.get(i).setLocation(gameMap.getCell(unitLocations.get(2*i),unitLocations.get(2*i+1)));
        }
    }

    public void setLocation(ArrayList<Integer> locations){
        for (int i = 0; i < units.size()*2; i+=2) {
            unitLocations.add(locations.get(i));
            unitLocations.add(locations.get(i+1));
        }
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

    public void setMap(Field gameMap) {
        this.gameMap = gameMap;
    }
}
