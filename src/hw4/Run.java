package hw4;

public class Run {
    public static void main(String[] args) {
        Folder root = new Folder("root");

            Folder d1 = new Folder("d1");
            d1.addFile(new File("f1"));
            d1.addFile(new File("f2"));

            Folder d2 = new Folder("d2");
                Folder d3 = new Folder("d3");
                d3.addFile(new File("f3"));
            d2.addFolder(d3);
            d2.addFile(new File("f4"));

        Folder dn = new Folder();
        root.addFolder(dn);
        root.addFolder(d1);
        root.addFolder(d2);
        root.addFile(new File("f5"));
        root.getTree();
        System.out.println("Total size is: " + root.getSize());
    }

}
