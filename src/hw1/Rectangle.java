package hw1;

public class Rectangle {
    private int h;
    private int w;
    private int ID;
    public static int cnt;

    public Rectangle(int h, int w) {
        this.h = h;
        this.w = w;
        cnt++;
        ID = cnt;
    }

    public Rectangle() {
        this(1, 1);
    }

    public int getID() {
        return ID;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public int perim() {
        return 2 * h + 2 * w;
    }

    public int area() {
        return h * w;
    }
}
