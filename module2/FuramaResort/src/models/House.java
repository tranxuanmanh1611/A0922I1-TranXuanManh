package models;

public class House extends Facility {
    private String roomStandard;
    private int floor;

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public House() {}

    public House(String name, int usableArea, int cost, int maxCapacity, String rentType, String roomStandard, int floor) {
        super(name, usableArea, cost, maxCapacity, rentType);
        setRoomStandard(roomStandard);
        setFloor(floor);
    }
}
