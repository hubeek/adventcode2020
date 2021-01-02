package nl.appall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Passport {

    ArrayList<String> requiredFields = new ArrayList<String>(Arrays.asList(
            "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"
    ));

    public void addField(String field) {
        requiredFields.remove(field);
    }

    public boolean hasValidFields() {
        return requiredFields.isEmpty();
    }

    public boolean isValidField(String field, String value) {
        boolean result = true;
        switch (field) {
            case "byr":
                //byr (Birth Year) - four digits; at least 1920 and at most 2002.
                if (NotinRangeCheck(value, 1920, 2002)) result = false;
                break;
            case "iyr":
                //iyr (Issue Year) - four digits; at least 2010 and at most 2020.
                if (NotinRangeCheck(value, 2010, 2020)) result = false;
                break;
            case "eyr":
                //eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
                if (NotinRangeCheck(value, 2020, 2030)) result = false;
                break;
            case "hgt":
                if (value.contains("cm") || value.contains("in")) {
                    var measure = Integer.parseInt(value.trim().replace("in", "").replace("cm", ""));
                    if (value.contains("cm") && (measure < 150 || measure > 193)) {
                        result = false;
                    } else if (value.contains("in") && (measure < 59 || measure > 76)) {
                        result = false;
                    }
                } else {
                    result = false;
                }
                ;
                break;
            case "hcl":
                //hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
                if (!value.matches("#{1}[a-f,0-9]{6}")) result = false;
                break;
            case "ecl":
                //ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
                var strings = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
                if (!strings.contains(value)) result = false;
                break;
            case "pid":
                //pid (Passport ID) - a nine-digit number, including leading zeroes.
                if(!value.matches("[0-9]{9}")) result = false;
                break;
        }
        return result;
    }

    private boolean NotinRangeCheck(String value, int least, int most) {
        int year = Integer.parseInt(value.trim());
        return value.length() != 4 || year < least || year > most;
    }
}
