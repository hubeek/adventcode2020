package nl.appall;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class advent09 {
    public static long[] numbers;
    public static void main(String[] args) throws IOException {
        System.out.println("Day 9");
        System.out.println("=====");
        long answerOne = doPuzzleOne();
        doPuzzleTwo(answerOne);
    }

    private static void doPuzzleTwo(long answerOne) {
        System.out.println("Puzzle 2");
        System.out.println("find sum of min and max in numbers to equal result from puzzle 1.");
        long found = findConsequtiveValues(answerOne);
        System.out.println(found);
    }

    private static long doPuzzleOne() throws IOException {
        System.out.println("Puzzle 1");
        String preambleFile = new String(Files.readAllBytes(Paths.get("09 - preamble.txt")));
        List<String> StringNumbers = Arrays.asList(preambleFile.split("\n"));
        int size = StringNumbers.size();
        numbers = new long[size];
        longArrayCreation(StringNumbers, size, numbers);
        int preamble = 25;
        int indexCheckNumber = 25;
        for (int i = preamble; i < numbers.length; i++) {
            indexCheckNumber = i;
            if (!check(indexCheckNumber, numbers, preamble)) {

                System.out.println(String.format("pos %d value %d is %b", indexCheckNumber, numbers[indexCheckNumber], check(indexCheckNumber, numbers, preamble)));
                return numbers[indexCheckNumber];
            }
        }
        return -1;
    }

    private static void longArrayCreation(List<String> StringNumbers, int size, long[] numbers) {
        for (int i = 0; i < size; i++) {
            numbers[i] = Long.parseLong(StringNumbers.get(i));
        }
    }

    private static boolean check(int indexCheckNumber, long[] numbers, int preamble) {

        long checkNumber = numbers[indexCheckNumber];
        int beg = (int) (indexCheckNumber - preamble);
        int end = (int) (indexCheckNumber);

        long[] subarray = new long[preamble];

        subarray = Arrays.copyOfRange(numbers, beg, end);
        boolean found = false;
        for (int i = 0; i < subarray.length; i++) {
            for (int j = 1; j < subarray.length; j++) {
                if (subarray[i] != subarray[j]) {
                    if (subarray[i] + subarray[j] == checkNumber) {
                        return true;

                    }
                }
            }
        }
        return false;
    }

    public static boolean check(int position, List<Integer> numbers, int preamble) {
        Integer[] numbersArray = new Integer[numbers.size()];
        numbersArray = numbers.toArray(numbersArray);
        int checkNumber = numbersArray[position];
        int beg = position - preamble;
        int end = position - 1;

        Integer[] subarray = new Integer[end - beg + 1];

        System.arraycopy(numbersArray, beg, subarray, 0, subarray.length);
        boolean found = false;
        for (int i = 0; i < subarray.length; i++) {
            for (int j = 1; j < subarray.length; j++) {
                if (subarray[i] != subarray[j]) {
                    if (subarray[i] + subarray[j] == checkNumber) {
                        return true;

                    }
                }
            }
        }
        return false;
    }

    public static long findConsequtiveValues(long findNumber) {
        int start = 0;
        Long[] lnumbers = new Long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            lnumbers[(int) i] = Long.parseLong(String.valueOf(numbers[i]));
        }
        for (int i = start; i < numbers.length ; i++) {

            for (int j = i+1; j < numbers.length ; j++) {
                Long[] subarray = new Long[j];
                subarray = Arrays.copyOfRange(lnumbers, i, j);
                long sum = Arrays.stream(subarray).mapToLong(Long::longValue).sum();
                if (sum == findNumber) {
//                    System.out.println(Arrays.toString(subarray));
                    return (long) Arrays.stream(subarray).mapToLong(v->v).min().orElse(-1) +
                            Arrays.stream(subarray).mapToLong(v->v).max().orElse(1);
                }
            }

        }
        return -1L;
    }

    public static int findConsequtiveValues(List<Integer> numbers, int findNumber) {
        int start = 0;
        Integer[] inumbers = numbers.toArray(new Integer[0]);
        for (int i = start; i < numbers.size() ; i++) {

            for (int j = i+1; j < numbers.size() ; j++) {
                Integer[] subarray = new Integer[j];
                subarray = Arrays.copyOfRange(inumbers, i, j);
                int sum = Arrays.stream(subarray).mapToInt(Integer::intValue).sum();
                if (sum == findNumber) {
                    return (int) Arrays.stream(subarray).mapToInt(v->v).min().orElse(-1) + Arrays.stream(subarray).mapToInt(v->v).max().orElse(1);
                }
            }

        }
        return -1;
    }
}
