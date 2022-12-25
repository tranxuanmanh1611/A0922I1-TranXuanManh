public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        long time1 = System.currentTimeMillis();
        this.startTime = time1;
    }

    public void stop() {
        long time2 = System.currentTimeMillis();
        this.endTime = time2;
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }
}


