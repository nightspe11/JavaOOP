package hw1;

public class PalindromeChecker {
    private String P;
    private boolean isPalindrome;
    public static int cnt;

    public PalindromeChecker(String p) {
        P = p;
        isPalindrome = isPalindrome();
        if(isPalindrome)cnt++;
    }

    public String getP() {
        return P;
    }

    public boolean isPalindrome(){
        boolean ret = false;
        String [] arr = P.split("");
        for (int i = 0; i < arr.length/2; i++) {
            if(arr[i].equals(arr[arr.length-1-i])) ret = true;
            else {
                ret = false;
                break;
            }
        }
        return ret;
    }
}
