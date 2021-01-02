package nl.appall;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;



public class advent02Test {

    @Test
    public void firstPuzzleTest(){
        String[] passwordList = {"1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc"};
        assertTrue(passwordList.length==3);
        int countValidPassword = 0;
        for (String line: passwordList){
            boolean result = advent02.isWithinRule(line);
            if (result) {countValidPassword++;}
        }
        System.out.println(String.format("Valid passwords %d", countValidPassword));
        assertTrue(countValidPassword==2);
    }

    @Test
    public void secondPuzzleTest(){
        String[] passwordList = {"1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc"};
        assertTrue(passwordList.length==3);
        int countValidPassword = 0;
        for (String line: passwordList){
            boolean result = advent02.isWithinSecondRule(line);
            if (result) {countValidPassword++;}
        }
        System.out.println(String.format("Valid passwords %d", countValidPassword));
        assertTrue(countValidPassword==1);
    }

}
