package models;

public class Villa extends Facility {
    private String roomStandard;
    private int poolArea;

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public Villa() {
    }

    public Villa(String name, int usableArea, int cost, int maxCapacity, String rentType, String roomStandard, int poolArea) {
        super(name, usableArea, cost, maxCapacity, rentType);
        setRoomStandard(roomStandard);
        setPoolArea(poolArea);
    }
}
