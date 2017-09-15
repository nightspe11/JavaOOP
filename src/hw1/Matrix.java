package hw1;

import java.util.ArrayList;

public class Matrix {
    private int turnDeg;
    ArrayList<ArrayList<Integer>> matrix;
    private int size;

    public Matrix(ArrayList<ArrayList<Integer>> matrix) {
        this.turnDeg = 0;
        this.matrix = matrix;
        if (matrix.size() == matrix.get(0).size()) this.size = matrix.size();
        else return;
    }

    public Matrix(int size) {
        this.turnDeg = 0;
        this.size = size;
        ArrayList<ArrayList<Integer>> row = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> col = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                col.add((int) (Math.random() * 10));
            }
            row.add(col);
        }
        matrix = row;
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            System.out.println(matrix.get(i));
        }
    }

    public void printTurnDeg() {
        System.out.println("Текущий угол поворота: " + getTurnDeg());
    }

    private boolean checkTurnDeg(int turnDeg) {
        if (turnDeg % 90 == 0) return true;
        else {
            this.turnDeg = 0;
            System.out.println(turnDeg + " это недопустимый угол поворота!");
            return false;
        }
    }

    public void rotateMatrix(int turnDeg) {
        if (checkTurnDeg(turnDeg)) this.turnDeg += turnDeg;
        switch (turnDeg) {
            case 90:
            case -270:
                rotate();
                break;
            case 180:
            case -180:
                rotate();
                rotate();
                break;
            case 270:
            case -90:
                rotate();
                rotate();
                rotate();
                break;
            default:
                break;
        }
    }

    private void rotate() {
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size - 1; j++) {
                int e = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(size - 1 - j).get(i));
                matrix.get(size - 1 - j).set(i, matrix.get(size - 1 - i).get(size - 1 - j));
                matrix.get(size - 1 - i).set(size - 1 - j, matrix.get(j).get(size - 1 - i));
                matrix.get(j).set(size - 1 - i, e);
            }
        }
    }

    public int getTurnDeg() {
        return turnDeg;
    }

    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }

    public int getSize() {
        return size;
    }
}
