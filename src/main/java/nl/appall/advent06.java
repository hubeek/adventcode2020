package nl.appall;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class advent06 {

    private static String answers;

    public static void main(String[] args) throws IOException {
        System.out.println("Day 6");
        System.out.println("=====");
        answers = new String(Files.readAllBytes(Paths.get("06 - answers.txt")));
        System.out.println(calcFromGroups(answers));
    }

    public static int calcFromGroup(List<String> answers) {
        List<String> letterAnsers = new ArrayList<String>();
        for (String answer: answers){
            for (String letter: answer.trim().split("")){
                if (!letter.equals("")) letterAnsers.add(letter);
            }
        }
        Set<String> result = new HashSet<>(letterAnsers);
        return result.size();
    }

    public static int calcFromGroups(String answers) {
        List<String> answersInGroup = new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        for (String line: answers.split("\n")) {
            if (line.equals("\n") || line.equals("")) {
                results.add(calcFromGroup(answersInGroup));
                answersInGroup = new ArrayList<>();
                continue;
            }
            answersInGroup.add(line);
        }
        if (answersInGroup.size() > 0) {
            results.add(calcFromGroup(answersInGroup));
        }
        return results.stream().mapToInt(Integer::valueOf).sum();
    }
}
