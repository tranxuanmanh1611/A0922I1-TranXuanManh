package models;

public abstract class Facility {
    private String name;
    private int usableArea;
    private int cost;
    private int maxCapacity;
    private String rentType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(int usableArea) {
        this.usableArea = usableArea;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public Facility() {}

    public Facility(String name, int usableArea, int cost, int maxCapacity, String rentType) {
        setName(name);
        setUsableArea(usableArea);
        setCost(cost);
        setMaxCapacity(maxCapacity);
        setRentType(rentType);
    }
}
