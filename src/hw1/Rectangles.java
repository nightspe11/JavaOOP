package hw1;

import java.util.ArrayList;

public class Rectangles {

    private ArrayList<Rectangle> recList = new ArrayList<>();

    public Rectangles() {
        this.recList = recList;
    }

    public void addRectangle(Rectangle r) {
        recList.add(r);
    }

    public int totalArea() {
        int area = 0;
        for (Rectangle i : recList) {
            area += i.area();
        }
        return area;
    }

    public void getAllRectangles() {
        System.out.println("Использованные прямоугольники:");
        for (Rectangle i : recList) {
            System.out.println(i.getW() + " x " + i.getH() + "\t S=" + i.area());
        }
        System.out.println("Суммарная площадь: " + this.totalArea());
    }
}
