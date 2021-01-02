package nl.appall;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class advent03Test {
    @Test
    public void advent03Exists() {
        assertNotNull(advent03.class);
    }

    @Test
    public void testMap() {
        ArrayList<String> map = new ArrayList<>(Arrays.asList(
                "..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#"
        ));
        int trees = advent03.stepThrough(map, 3, 1);
        assertEquals(7, trees);
    }

    @Test
    public void secondTest() {
        ArrayList<String> map = new ArrayList<>(Arrays.asList(
                "..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#"
        ));
        ArrayList<Integer> results = new ArrayList<>();
        int trees = advent03.stepThrough(map, 1, 1);
        assertEquals(2, trees);
        results.add(trees);

        trees = advent03.stepThrough(map, 3, 1);
        assertEquals(7, trees);
        results.add(trees);

        trees = advent03.stepThrough(map, 5, 1);
        assertEquals(3, trees);
        results.add(trees);

        trees = advent03.stepThrough(map, 7, 1);
        assertEquals(4, trees);
        results.add(trees);

        trees = advent03.stepThrough(map, 1, 2);
        assertEquals(2, trees);
        results.add(trees);
        int total = results.stream().reduce(1, (a, b) -> a * b);
        assertEquals(336, total);
    }
}
