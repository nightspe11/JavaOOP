package hw1;

public class Square implements Shape {

    private  final Rectangle rectangle;

    public Square(Rectangle rectangle) {
        this.rectangle = new Rectangle(5,5);
    }

    public double perim() {
        return rectangle.perim();
    }

    public double area() {
        return rectangle.area();
    }
}
