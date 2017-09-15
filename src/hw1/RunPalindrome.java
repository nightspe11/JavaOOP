package hw1;
// Ввести N чисел с консоли. Среди чисел найти число-палиндром. Если таких чисел больше одного,  найти второе.

public class RunPalindrome {
    public static void main(String[] args) {

        DataInput input = new DataInput("e");
        //input.printList();
        for (String str : input.getList()) {
            PalindromeChecker pal = new PalindromeChecker(str);
            if (pal.isPalindrome()) System.out.println(pal.getP());
        }
        System.out.println("Найдено палиндромов: " + PalindromeChecker.cnt);
    }
}
