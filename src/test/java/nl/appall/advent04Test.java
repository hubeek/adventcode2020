package nl.appall;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class advent04Test {

    @Test
    public void advent04Created() {
        assertNotNull(advent04.class);
        assertNotNull(Passport.class);
    }

    @Test
    public void passportTests(){
        Passport passport = new Passport();
        assertEquals(passport.requiredFields.size(), 7);
        passport.addField("byr");
        assertEquals(passport.requiredFields.size(), 6);
        passport.addField("iyr");
        passport.addField("eyr");
        passport.addField("hgt");
        passport.addField("hcl");
        passport.addField("ecl");
        passport.addField("pid");
        assertEquals(passport.requiredFields.size(), 0);
        assertTrue(passport.hasValidFields());
    }

    @Test
    public void exampleTest() throws IOException {

        int results = advent04.getValidPassports("src/test/java/nl/appall/example04.txt");
        assertEquals(results, 2);
    }

    @Test
    public void exampleValueValidate(){
        Passport passport = new Passport();
        assertTrue(passport.isValidField("byr","2002"));
        assertFalse(passport.isValidField("byr","2003"));
        assertTrue(passport.isValidField("hgt","60in"));
        assertTrue(passport.isValidField("hgt","190cm"));
        assertFalse(passport.isValidField("hgt","190"));
        /*

        hcl valid:   #123abc
        hcl invalid: #123abz
        hcl invalid: 123abc

        ecl valid:   brn
        ecl invalid: wat

        pid valid:   000000001
        pid invalid: 0123456789*/
    }

}
