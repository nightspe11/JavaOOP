package hw1;
// Ввести N чисел с консоли. Среди чисел найти число-палиндром. Если таких чисел больше одного,  найти второе.

import java.util.Date;

public class Palindrome {
    static public String TODAY;

    static { // статический конструктор
        Date d = new Date();
        if (d.getDay() == 0) TODAY = "Sunday";
        else if (d.getDay() == 1) TODAY = "Monday";
    }
}
