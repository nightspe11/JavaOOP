package hw1;

/*Создать классы:
1. Rectangle (Прямоугольник), содержащий размеры (высоту и ширину), и умеющий подсчитывать свои периметр и площадь.
2. Rectangles (Прямоугольники), содержащий список прямоугольников, умеющий добавлять новые прямоугольники и подсчитывать их суммарную площадь. Подсказка: реализовать на основании ArrayList.
3. Клиентский класс RectangleRunner, демонстрирующий работу предыдущих классов.*/

public class Run {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(17,8);
        System.out.println("Прямоугольник: "+r1.getH()+" x "+r1.getW());
        System.out.println("Периметр: "+r1.perim()+"\tПлощадь: "+r1.area()+"\n");
        Rectangle r2 = new Rectangle();
        Rectangle r3 = new Rectangle(15,8);
        Rectangles R = new Rectangles();
        R.addRectangle(r1);
        R.addRectangle(r2);
        R.addRectangle(r3);
        R.getAllRectangles();
     }
}
