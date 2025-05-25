import java.io.*;
import java.util.*;

public class CarBuildIO {

    public static void saveToFile(CarBuild build, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(build.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void saveListToFile(List<CarBuild> builds, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (CarBuild build : builds) {
                writer.write(build.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing list to file: " + e.getMessage());
        }
    }

    public static List<String> readFromFile(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return lines;
    }
}