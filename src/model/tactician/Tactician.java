package model.tactician;

import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Tactician {
    private String name;
    private ArrayList<IUnit> units = new ArrayList<>();
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
    public void endTurn(){
        changes.firePropertyChange(new PropertyChangeEvent(this,"PassTurn",null,null));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tactician){
            return this.getName().equals(((Tactician) obj).getName());
        }
        return false;
    }
}
