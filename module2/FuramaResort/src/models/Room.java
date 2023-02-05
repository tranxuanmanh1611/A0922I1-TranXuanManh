package models;

public class Room extends Facility {
    private String freeService;

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public Room() {
    }

    public Room(String name, int usableArea, int cost, int maxCapacity, String rentType, String freeService) {
        super(name, usableArea, cost, maxCapacity, rentType);
        setFreeService(freeService);
    }
}
