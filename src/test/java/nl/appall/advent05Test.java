package nl.appall;


import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class advent05Test {

    @Test
    public void advent05Created() {
        assertNotNull(advent05.class);
    }

    @Test
    public void seatsTest(){
        assertEquals(357, advent05.getSeatFrom("FBFBBFFRLR"));
        assertEquals(567, advent05.getSeatFrom("BFFFBBFRRR"));
        assertEquals(119, advent05.getSeatFrom("FFFBBBFRRR"));
        assertEquals(820, advent05.getSeatFrom("BBFFBBFRLL"));
    }
}
