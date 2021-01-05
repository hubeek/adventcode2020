package nl.appall;


import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class advent09Test {

    List<Integer> numbers = Arrays.asList(35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576);

    @Test
    public void advent8created() {
        assertNotNull(advent09.class);
    }

    @Test
    public void testNumberArray() {
        int preamble = 5;
        int indexCheckNumber = 5;
        assertTrue(advent09.check(indexCheckNumber, numbers, preamble));
        for (int i = 5; i < numbers.size(); i++) {
            indexCheckNumber = i;
            System.out.println(String.format("pos %d value %d is %b", indexCheckNumber, numbers.get(indexCheckNumber), advent09.check(indexCheckNumber, numbers, preamble)));
        }
    }

    @Test
    public void consequtiveNumbersTest(){

        int result = advent09.findConsequtiveValues(numbers, 127);
        System.out.println(result);
    }

}
