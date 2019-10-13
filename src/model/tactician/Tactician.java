package model.tactician;

import model.units.IUnit;
import model.units.UnitFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;

public class Tactician {
    private String name;
    private ArrayList<IUnit> units = new ArrayList<>();
    private UnitFactory unitFactory = new UnitFactory();
    private PropertyChangeSupport changes;
    public Tactician(String name){
        this.name = name;
        changes = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }
//TODO unitfactory gigante que le da unidades a cada tactician
    public void addUnit(String unitType){

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
