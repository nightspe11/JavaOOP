package hw1;

import java.util.ArrayList;
import java.util.Scanner;

public class DataInput {
    private ArrayList<String> list;
    private String brakeSequence;

    public DataInput(String brakeSequence) {
        this.brakeSequence = brakeSequence;
        Scanner sc = new Scanner(System.in);
        String s;
        this.list = new ArrayList<>();
        System.out.println("Для завершения ввода введите \""+brakeSequence+"\"");
        while (true) {
            s = sc.nextLine();
            if (s.equals(brakeSequence)) break;
            list.add(s);
        }
    }

    public ArrayList<String> getList() {
        return list;
    }

    public DataInput() {
        this("!");
    }

    public void printList() {
        System.out.println(list.toString());
    }
}
