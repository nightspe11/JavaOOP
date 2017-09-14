package ua.i.ightspell;

public class Test {
    public Test() {
    }

    @Override
    public String toString() {
        return "Test{}";
    }

    public static void main(String[] args) {//
        // TODO Auto-generated method stub//
        String hello_world2 = "HELLO WORLD2";
        output(hello_world2);
        output("ei" +
                "");
       // throw new exception
        System.out.println();
    }

    private static void output(String wtf) {
        System.out.println(wtf);
    }
}
