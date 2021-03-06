package nl.appall;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;

public class advent08Test {

    @Test
    public void advent8created() {
        assertNotNull(advent08.class);
    }

    @Test
    public void exampleProgram() {
        String program = "nop +0\n" +
                "acc +1\n" +
                "jmp +4\n" +
                "acc +3\n" +
                "jmp -3\n" +
                "acc -99\n" +
                "acc +1\n" +
                "jmp -4\n" +
                "acc +6";
        List<String> operations = Arrays.asList(program.split("\n"));
        int accumulator = 0;
        advent08.run(operations, accumulator);
    }

    @Test
    public void exampleProgramChangeNopJmp() {
        String program = "nop +0\n" +
                "acc +1\n" +
                "jmp +4\n" +
                "acc +3\n" +
                "jmp -3\n" +
                "acc -99\n" +
                "acc +1\n" +
                "jmp -4\n" +
                "acc +6";
        List<String> operations = Arrays.asList(program.split("\n"));
        int accumulator = 0;
        var countops = operations.stream().filter(l -> l.contains("jmp") || l.contains("nop")).collect(Collectors.toList());

        advent08.runWithChanger(operations, accumulator, countops.size());
    }

    @Test
    public void exampleProgram2Solution() {
        String program = "nop +0\n" +
                "acc +1\n" +
                "jmp +4\n" +
                "acc +3\n" +
                "jmp -3\n" +
                "acc -99\n" +
                "acc +1\n" +
                "nop -4\n" +
                "acc +6";
        List<String> operations = Arrays.asList(program.split("\n"));
        int accumulator = 0;
        advent08.run(operations, accumulator);

    }
}
