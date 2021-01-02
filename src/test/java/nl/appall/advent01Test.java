package nl.appall;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class advent01Test {

    private ArrayList<Integer> testset = new ArrayList<>();

    Integer[] a = {1721, 979, 366, 299, 675, 1456};

    @Before
    public void setup() {
        testset.addAll(Arrays.<Integer>asList(a));
    }

    @Test
    public void testFirst() {
        int result = advent01.findSolution(testset);
        assertFalse(result == -1);
        assertTrue(result == 514579);
    }

    @Test
    public void testSecond() {
        int result = advent01.findSolutionWith3(testset);
        assertFalse(result == -1);
        assertTrue(result == 241861950);
    }
}
