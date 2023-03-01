package models;

public class House extends Facility {
    int usedTime = 0;
    private String roomStandard;
    private int floor;
    public int getUsedTime(){
        return usedTime;
    }

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

    public House(String serviceName, int usableArea, int cost, int maxCapacity, String rentType, String roomStandard, int floor) {
        super(serviceName, usableArea, cost, maxCapacity, rentType);
        setRoomStandard(roomStandard);
        setFloor(floor);
    }

    @Override
    public String toString() {
        return "House{"+ super.toString() +
                ", usedTime=" + usedTime +
                ", roomStandard='" + roomStandard + '\'' +
                ", floor=" + floor +
                "} " ;
    }
}
