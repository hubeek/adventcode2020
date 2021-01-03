package nl.appall;


import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class advent06Test {
    @Test
    public void advent06Created() {
        assertNotNull(advent06.class);
    }

    @Test
    public void calcCleanOfGroup() {
        List<String> answers = Arrays.asList("abcx", "abcy", "abcz");
        int result = advent06.calcFromGroup(answers);
        assertEquals(6, result);
    }

    @Test
    public void calcGroups() {
        String answers = "abc\n" +
                "\n" +
                "a\n" +
                "b\n" +
                "c\n" +
                "\n" +
                "ab\n" +
                "ac\n" +
                "\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "\n" +
                "b";
        int result = advent06.calcFromGroups(answers);
        assertEquals(11, result);
    }

    @Test
    public void getSameAnswerOfGroupMembers(){
        String answers = "abc\n" +
                "\n" +
                "a\n" +
                "b\n" +
                "c\n" +
                "\n" +
                "ab\n" +
                "ac\n" +
                "\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "\n" +
                "b";
        int result = advent06.calcFromGroupsSame(answers);
        assertEquals(6, result);
    }
}
