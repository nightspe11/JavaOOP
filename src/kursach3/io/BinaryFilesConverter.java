package kursach3.io;

import java.io.*;

public class BinaryFilesConverter {
    public static void convertIntoFile(Object obj, String file) throws IOException {
        try (ObjectOutput outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            outputStream.writeObject(obj);
        }
    }

    public static <T> T restoreFromFile(String file, Class<T> type) throws IOException, ClassNotFoundException {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(file))) {
            return type.cast(objectInput.readObject());
        }
    }
}
