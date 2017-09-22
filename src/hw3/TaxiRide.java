package hw3;

public class TaxiRide {
    private int distance;
    private int duration;
    private int pasCount;

    public TaxiRide(int distance, int duration, int pasCount) {
        this.distance = distance;
        this.duration = duration;
        this.pasCount = pasCount;
    }

    public int getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }

    public int getPasCount() {
        return pasCount;
    }
}
