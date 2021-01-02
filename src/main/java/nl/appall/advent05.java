package nl.appall;

import org.w3c.dom.ranges.Range;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.IntStream;

public class advent05 {
    private static String[] lines;
    private static String seatsFile;

    public static void main(String[] args) throws IOException {
        seatsFile = new String(Files.readAllBytes(Paths.get("05 - seats.txt")));
        lines = seatsFile.split("\n");
        System.out.println("Day 5");
        System.out.println("=====");
        System.out.println("puzzle 1");
        System.out.println(getSolutionFirstPuzzle());
        System.out.println("=====");
        System.out.println("puzzle 2");
        System.out.println(getSolutionSecondPuzzle());

    }

    private static int getSolutionSecondPuzzle() {
//        System.out.println(lines.length);
        ArrayList<Integer> seats = new ArrayList<Integer>();
        for (String seatcode: lines){
            int seat = getSeatFrom(seatcode);
            seats.add(seat);
        }

        Collections.sort(seats);
        int first = seats.get(0);
        for (int i = 1; i < seats.size(); i++) {
            if (first+1 != seats.get(i)) {
//                System.out.println(String.format("found %d", first+1));
                return first+1;
            }
            first = seats.get(i);
        }

        return 0;
    }

    private static int getSolutionFirstPuzzle() throws IOException {
        int highest = -1;
        for (String seatcode: lines){
            int seat = getSeatFrom(seatcode);
            if (seat > highest) highest = seat;
        }
        return highest;
    }

    public static int getSeatFrom(String seatString) {
        int[] row = new int[128];
        int[] column = new int[8];
        for (int i = 0; i < 128; i++) {
            row[i] = i;
        }
        for (int i = 0; i < 8; i++) {
            column[i] = i;
        }
        for (String portion: seatString.toUpperCase().split("")) {
            if (portion.equals("F")) {
                row = getHalf(row, portion);
            } else if (portion.equals("B")) {
                row = getHalf(row, portion);
            } else if (portion.equals("L")) {
                column = getHalf(column, portion);
            } else if (portion.equals("R")) {
                column = getHalf(column, portion);
            }
        }
        int result = row[0] * 8 + column[0];
        return result;
    }

    private static int[] getHalf(int[] inputArray, String portion) {
        int[] firstPart = Arrays.copyOfRange(inputArray, 0, inputArray.length/2);
        int[] secondPart = Arrays.copyOfRange(inputArray, inputArray.length/2, inputArray.length);
        if (portion.equals("F")) {
            return firstPart;
        } else if (portion.equals("B")){
            return secondPart;
        } else if (portion.equals("L")) {
            return firstPart;
        }
            return secondPart;

    }


}
