package nl.appall;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class advent08 {

    private static String bootcode;
    private static int opsCounter = -1;
    private static int opsValue = -1;
    private static boolean opsChanged = false;
    private static boolean found = false;


    public static void main(String[] args) throws IOException {
        System.out.println("Day - 8");
        System.out.println("=======");
        doPuzzleOne();
        doPuzzleTwo();
    }

    private static void doPuzzleOne() throws IOException {
        System.out.println("Puzzle 1");
        bootcode = new String(Files.readAllBytes(Paths.get("08 - bootcode.txt")));
        List<String> operations = Arrays.asList(bootcode.split("\n"));
        int accumulator = 0;
        run(operations, accumulator);

    }

    private static void doPuzzleTwo() throws IOException {
        System.out.println("Puzzle 2");
        bootcode = new String(Files.readAllBytes(Paths.get("08 - bootcode.txt")));
        List<String> operations = Arrays.asList(bootcode.split("\n"));
        int accumulator = 0;
        var countops = operations.stream().filter(l -> l.contains("jmp") || l.contains("nop")).collect(Collectors.toList());

        runWithChanger(operations, accumulator, countops.size());

    }

    public static void run(List<String> operations, int accumulator) {
        int step = 0;
        List<Integer> steps = new ArrayList<>();
        doOperation(step, operations, accumulator, steps);
    }


    private static boolean doOperation(
            int step,
                    List<String> operations,
                    int accumulator,
                    List<Integer> steps)
    {


        if (step == operations.size()) {
            System.out.println(String.format("end! acc: %d", accumulator));
            found = true;
            return found;
        }
        if (step > operations.size()) {
            System.out.println(String.format("step bigger than size %", step));
            step = step % operations.size();
        } else if (step < 0) {
            step = operations.size() + step;
        }
        if (steps.contains(step)) {
            if (opsValue == -1) {
                System.out.println(String.format("is in loop! acc: %s", accumulator));
                return true;
            } else {
                found = false;
                return found;
            }

        } else {
            steps.add(step);
        }

        String operationLine = operations.get(step);
//        System.out.println(String.format("%s %s  %d", operationLine, accumulator, step));
        String operation = operationLine.split(" ")[0];
        String argument = operationLine.split(" ")[1];
        if (opsChanged == false && opsValue != -1
                && opsValue == opsCounter
                && (operation.contains("jmp")||operation.contains("nop"))) {
            operation = changeOperation(operation);
        }
        if (operation.contains("jmp")||operation.contains("nop")) opsCounter++;
        switch (operation) {
            case "nop":
                step += 1;
                doOperation(step, operations, accumulator, steps);
                break;
            case "acc":
                accumulator += Integer.parseInt(argument);
                step += 1;
                doOperation(step, operations, accumulator, steps);
                break;
            case "jmp":
                step += Integer.parseInt(argument);
                doOperation(step, operations, accumulator, steps);
                break;
            default:
                System.out.println(operation);
                break;
        }
        return found;
    }

    private static String changeOperation(String operation) {
        opsChanged = !opsChanged;
        if (operation.contains("jmp")) {
            return operation.replace("jmp", "nop");
        } else if (operation.contains("nop")) {
            return operation.replace("nop", "jmp");
        }
        return operation;
    }

    public static void runWithChanger(List<String> operations, int accumulator, int countops) {
        for (int i = 0; i < countops; i++) {
//            System.out.println(String.format("%d try",i));
            int step = 0;
            List<Integer> steps = new ArrayList<>();
            opsCounter = 0;
            opsValue = i;
            opsChanged = false;
            accumulator = 0;
            found = false;
            if (doOperation(step, operations, accumulator, steps)) {
                System.out.println(String.format("found at try %d ", i));
                break;
            } else {
//                System.out.println("Not found!");
            }
        }
    }
}
