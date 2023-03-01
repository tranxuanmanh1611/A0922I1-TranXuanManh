package models;

public class Villa extends Facility {
    int usedTime = 0;
    private String roomStandard;
    private int poolArea;

    public int getUsedTime() {
        return usedTime;
    }

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

    public Villa(String serviceName, int usableArea, int cost, int maxCapacity, String rentType, String roomStandard, int poolArea) {
        super(serviceName, usableArea, cost, maxCapacity, rentType);
        setRoomStandard(roomStandard);
        setPoolArea(poolArea);
    }

    @Override
    public String toString() {
        return "Villa{"+ super.toString() +
                ", usedTime=" + usedTime +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                "} " ;
    }
}
