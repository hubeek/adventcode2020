package nl.appall;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class advent04 {
    public static void main(String[] args) throws IOException {
        System.out.println("Puzzles Day 4");
        System.out.println("===");
        System.out.println(String.format("Puzzle 1 valid passports: %d", getValidPassports("04 - passports.txt")));
        System.out.println("===");
        System.out.println(String.format("Puzzle 2 valid passports: %d", getValidPassportsWithValidFields("04 - passports.txt")));
    }

    public static int getValidPassports(String passportfilePath) throws IOException {
        int result = 0;
        int passports=0;
        String passportfile = new String(Files.readAllBytes(Paths.get(passportfilePath)));
        String[] lines = passportfile.split("\n");
        Passport passport = new Passport();
        passports++;
        for (String line: lines){
            if (line.equals("")){
                if (passport.hasValidFields()) result++;
//                System.out.println("passport "+passport.hasValidFields());
                passport = new Passport();
                passports++;
                continue;
            }
//            System.out.println(line);
            String[] fields = line.split(" ");

            for (String group: fields){
                String[] groups = group.split(":");
                String fieldKey  = groups[0];
                passport.addField(fieldKey);
            }

        }
        if (passport.hasValidFields()) result++;
//        System.out.println("passport "+passport.hasValidFields());
//        System.out.println("result "+result);
//        System.out.println(String.format("total passports: %d",passports));
        return result;
    }

    public static int getValidPassportsWithValidFields(String passportfilePath) throws IOException {
        int result = 0;
        int passports=0;
        String passportfile = new String(Files.readAllBytes(Paths.get(passportfilePath)));
        String[] lines = passportfile.split("\n");
        Passport passport = new Passport();
        passports++;
        for (String line: lines){
            if (line.equals("")){
                if (passport.hasValidFields()) result++;
//                System.out.println("passport "+passport.hasValidFields());
                passport = new Passport();
                passports++;
                continue;
            }
//            System.out.println(line);
            String[] fields = line.split(" ");

            for (String group: fields){
                String[] groups = group.split(":");
                String fieldKey  = groups[0];
                String fieldValue = groups[1];
                var validField = passport.isValidField(fieldKey, fieldValue);
                if (validField) passport.addField(fieldKey);
            }

        }
        if (passport.hasValidFields()) result++;
//        System.out.println("passport "+passport.hasValidFields());
//        System.out.println("result "+result);
//        System.out.println(String.format("total passports: %d",passports));
        return result;
    }
}
