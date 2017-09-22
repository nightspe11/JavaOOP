package hw4;

import java.util.ArrayList;

public class Folder {
    public String name;
    private int size;
    private static int count = 1;
    private ArrayList<File> files = new ArrayList<>();
    private ArrayList<Folder> folders = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public Folder() {
        this("New Folder " + count);
        count++;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void addFile(File file) {
        this.size += file.getSize();
        files.add(file);
    }

    public void addFolder(Folder folder) {
        this.size += folder.getSize();
        folders.add(folder);
    }

    public void getTree() {
        if (folders.size() > 0) {
            System.out.println(name + " contains folders: ");
            for (Folder d : folders) {
                System.out.println(d.getName()+", s: "+d.getSize());
               // if (d.size > 0) d.getTree();
            }
        }
        if (files.size() > 0) {
            System.out.println(name + " contains files: ");
            for (File f : files) {
                System.out.println(f.getName()+", s: "+f.getSize());
            }
        }
    }
}
