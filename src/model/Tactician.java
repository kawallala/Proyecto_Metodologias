package model;

public class Tactician {
    private String name;
    public Tactician(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
//TODO unitfactory gigante que le da unidades a cada tactician

    public void beginTurn() {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tactician){
            return this.getName().equals(((Tactician) obj).getName());
        }
        return false;
    }
}
