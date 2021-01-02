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
        switch (field){
            case "byr":
                int year = Integer.parseInt(value.trim());
                if (value.length()!=4 || (year<1920||year>2002)) result = false;
                break;
            case"iyr":
                break;
            case "eyr":
                break;
            case "hgt":
                if (value.contains("cm")||value.contains("in")){
                    var measure = Integer.parseInt(value.trim().replace("in", "").replace("cm", ""));
                    if (value.contains("cm") && (measure < 150 || measure > 193)) {
                        result = false;
                    } else if (value.contains("in") && (measure < 59 || measure > 76)) {
                        result = false;
                    }
                } else {
                    result = false;
                }
                break;
            case "hcl":
                break;
            case "ecl":
                break;
            case "pid":
                break;
            default:
                break;
        }
        return result;
    }
}
