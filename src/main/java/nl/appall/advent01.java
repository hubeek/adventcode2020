package nl.appall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static nl.appall.FileIOHelper.*;

public class advent01 {

    private static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        numbers = ReadNumbersIn("01 - numbers.txt");
        System.out.println("Solutions for day 1\n");
        findSolutionOne();
        findSolutionTwo();
    }

    private static void findSolutionTwo() throws Exception {
        int result = findSolutionWith3(numbers);
        System.out.println(String.format("result for puzzle two: %d", result));
    }

    private static void findSolutionOne() throws Exception {
        int result = findSolution(numbers);
        System.out.println(String.format("result for puzzle one: %d", result));
    }

    private static ArrayList<Integer> readFileForNumbers() {

        ArrayList<Integer> numberList = new ArrayList<>();
        try {
            File file = new File("01 - numbers.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                int number = Integer.parseInt(string);
                numberList.add(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return numberList;
    }

    public static int findSolution(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == 2020) {
                    return (int) numbers.get(i).intValue() * numbers.get(j).intValue();
                }
            }
        }
        ;
        return -1;
    }

    public static int findSolutionWith3(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 1; j < numbers.size(); j++) {
                for (int k = 1; k < numbers.size(); k++) {
                    int sum = numbers.get(i) + numbers.get(j) + numbers.get(k);
                    if (sum == 2020) {
                        return numbers.get(i) * numbers.get(j) * numbers.get(k);
                    }
                }
            }
        }

        return -1;
    }
}
