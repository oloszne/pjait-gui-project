package model;

import java.io.*;

public class AppDataLoader {

    private static final String filename = "appdata.ser";

    public static void save(AppData data) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(data);
            System.out.println("AppData saved successfully.");
        } catch (IOException e) {
            System.err.println("Could not save AppData: " + e.getMessage());
        }
    }

    public static AppData load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            AppData data = (AppData) in.readObject();
            System.out.println("AppData loaded successfully.");
            return data;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load AppData: " + e.getMessage());
            return new AppData();
        }
    }
}
