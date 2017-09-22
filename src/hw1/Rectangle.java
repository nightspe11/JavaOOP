package hw1;

public class Rectangle implements Shape {
    private final int h; //final for immutable
    private final int w;
    private final int ID;
    public static int cnt;

    /**
     * Constructor
     *
     * @param h
     * @param w throw exceptions...
     */
    public Rectangle(int h, int w) {
        //if(w<0) exception
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

    public double perim() {
        return 2 * h + 2 * w;
    }

    public double area() {
        return h * w;
    }

}
