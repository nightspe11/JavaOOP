package kursach3.io;

import java.util.List;

public class PrintList {
    public static <E> void printList(List<E> list) {
        for (E elem : list) {
            System.out.println(elem);
        }
    }
}
