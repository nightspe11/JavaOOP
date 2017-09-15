package hw1;

/*Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.*/

public class MatrixRunner {
    public static void main(String[] args) {
        Matrix m = new Matrix(3);
        m.printMatrix();
        m.rotateMatrix(-90);
        m.rotateMatrix(+270);
        System.out.println();
        m.printMatrix();
        m.printTurnDeg();
        //m.rotateMatrix(+134);
    }
}
