package nl.appall;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIOHelper {

    public static void CreateFile(String filename){
        try {
            File file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            };
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        };
    };

    public static ArrayList<Integer> ReadNumbersIn(String filename) throws Exception {
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                int number = Integer.parseInt(string);
                numbers.add(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getLocalizedMessage());
        }
        return numbers;
    }

    public static <T> ArrayList<T> ReadValuesIn(String filename) throws Exception {
        ArrayList<T> values = new ArrayList<T>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String lineValue = scanner.nextLine();
                T value = (T) lineValue;
                values.add(value);
            };
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getLocalizedMessage());
        };
        return values;
    };
}
