package model.factories.item;

public abstract class AbstractEquipableItemFactory implements IEquipabbleItemFactory {
    private String name;
    private int power;
    private int minimumRange;
    private int maximumRange;

    public AbstractEquipableItemFactory() {
        this.setDefaults();
    }

    protected String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    protected int getPower() {
        return power;
    }

    @Override
    public void setPower(int power) {
        this.power = power;
    }

    protected int getMinimumRange() {
        return minimumRange;
    }

    @Override
    public void setMinimumRange(int minimumRange) {
        this.minimumRange = minimumRange;
    }

    protected int getMaximumRange() {
        return maximumRange;
    }

    @Override
    public void setMaximumRange(int maximumRange) {
        this.maximumRange = maximumRange;
    }
}
