package models;

public class Room extends Facility {
    int usedTime = 0;
    private String freeService;
    public int getUsedTime(){
        return usedTime;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public Room() {
    }

    public Room(String serviceName, int usableArea, int cost, int maxCapacity, String rentType, String freeService) {
        super(serviceName, usableArea, cost, maxCapacity, rentType);
        setFreeService(freeService);
    }
}
