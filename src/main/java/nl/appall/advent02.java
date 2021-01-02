package nl.appall;


import java.util.ArrayList;

import static nl.appall.FileIOHelper.ReadNumbersIn;

public class advent02 {

    private static ArrayList<String> lines = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        lines = FileIOHelper.ReadValuesIn("02 - passwords.txt");
        System.out.println("Solutions for day 2\n");
        System.out.println(String.format("lines %d", lines.size()));
        findSolutionOne(lines);
        findSolutionTwo(lines);
    }

    private static void findSolutionTwo(ArrayList<String> lines) {
        int countValidPassword = 0;
        for (String line : lines) {
            boolean result = advent02.isWithinSecondRule(line);
            if (result) {
                countValidPassword++;
            }
        }
        System.out.println(String.format("Valid passwords %d", countValidPassword));
    }

    private static void findSolutionOne(ArrayList<String> lines) {
        int countValidPassword = 0;
        for (String line : lines) {
            boolean result = advent02.isWithinRule(line);
            if (result) {
                countValidPassword++;
            }
        }
        System.out.println(String.format("Valid passwords %d", countValidPassword));
    }


    public static boolean isWithinRule(String line) {
        String[] parts = line.split(":");
        String rule = parts[0];
        String[] ruleSplit = rule.split(" ");
        String timesString = ruleSplit[0];
        String[] timesSplit = timesString.split("-");
        int lowest = Integer.parseInt(timesSplit[0]);
        int highest = Integer.parseInt(timesSplit[1]);
        String letter = ruleSplit[1];
        String[] passwordArray = parts[1].split("");

        int count = 0;
        for (String oneStr : passwordArray) {
            if (oneStr.equals(letter)) {
                count++;
            }
        }
//      System.out.println("not in the rule");
        if (count >= lowest && count <= highest) {
//                  System.out.println("Within rule");
            return true;
        }
        return false;


    }

    public static boolean isWithinSecondRule(String line) {
        String[] parts = line.split(":");
        String rule = parts[0];
        String[] ruleSplit = rule.split(" ");
        String timesString = ruleSplit[0];
        String[] timesSplit = timesString.split("-");
        int firstappearance = Integer.parseInt(timesSplit[0]) - 1;
        int secondappearance = Integer.parseInt(timesSplit[1]) - 1;
        String letter = ruleSplit[1];
        String[] passwordArray = parts[1].trim().split("");
        int count = 0;
        if (isInRange(passwordArray, firstappearance) && passwordArray[firstappearance].equals(letter)) {
            count++;
        }
        if (isInRange(passwordArray, secondappearance) && passwordArray[secondappearance].equals(letter)) {
            count++;
        }
//      System.out.println("not in the rule");
        if (count == 1) {
//                  System.out.println("Within rule");
            return true;
        }
        return false;
    }

    private static boolean isInRange(String[] passwordArray, int number) {
        if (number < 0) return false;
        if (number >= passwordArray.length) return false;
        return true;
    }
}
