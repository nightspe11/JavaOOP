package hw4;

public class File {
    private String name;
    private int size;

    public File(String name) {
        this.name = name;
        this.size = (int) (100 * Math.random());
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
