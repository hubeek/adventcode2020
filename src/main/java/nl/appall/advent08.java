package nl.appall;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;

public class advent08 {

    private static String bootcode;

    public static void main(String[] args) throws IOException {
        System.out.println("Day - 8");
        System.out.println("=======");
        doPuzzleOne();
    }

    private static void doPuzzleOne() throws IOException {
        bootcode = new String(Files.readAllBytes(Paths.get("08 - bootcode.txt")));
        List<String> operations = Arrays.asList(bootcode.split("\r\n"));
        int accumulator = 0;
        run(operations, accumulator);

    }

    public static void run(List<String> operations, int accumulator) {
        int step = 0;
        List<Integer> steps = new ArrayList<>();
        doOperation(step, operations, accumulator, steps);
    }

    private static void doOperation(int step, List<String> operations, int accumulator, List<Integer> steps) {
        if (step > operations.size()) {
            step = step % operations.size();
        } else if (step < 0) {
            step = operations.size() + step;
        }
        if (steps.contains(step)) {
            System.out.println(String.format("%s", accumulator));
            exit(0);
        } else {
            steps.add(step);
        }

        String operationLine = operations.get(step);
        System.out.println(String.format("%s %s", operationLine, accumulator));
        String operation = operationLine.split(" ")[0];
        String argument = operationLine.split(" ")[1];
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
    }

}
