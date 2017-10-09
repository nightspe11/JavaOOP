package hw5;

public interface Train {
    void turnLeft();
    void turnRight();
    void changeLampStatus();
    boolean isLampOn();
    boolean isLength(int expectedLength);
}