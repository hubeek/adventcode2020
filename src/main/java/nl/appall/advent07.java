package nl.appall;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class advent07 {

    private static String rules;
    private static int tempResult;
    public static int bagCounter;

    public static void main(String[] args) throws IOException {
        System.out.println("Day 7");
        System.out.println("=====");
        rules = new String(Files.readAllBytes(Paths.get("07 - bags.txt")));
        firstPuzzleToFindWhoCanContainShinyGoldenBag();
        secondPuzzle();
    }

    private static void secondPuzzle() {
        List<Bag> ruleBags = advent07.getBagsFrom(rules, ".\r\n");
        Bag shinyGoldenRule = advent07.createWholeBag("shiny gold", ruleBags);
        advent07.bagCounter = 0;
        int result = advent07.getTotalBagsFrom(shinyGoldenRule);
        System.out.println(String.format("\npuzzle 2 - %d", result));
    }

    private static void firstPuzzleToFindWhoCanContainShinyGoldenBag() {
        String color = "shiny gold";
        List<Bag> bags = advent07.getBagsFrom(rules, ".\r\n");
        int found = advent07.findBagWhichWillContain(color, bags);
        System.out.println(String.format("puzzle 1 - %d", found));
    }

    public static List<Bag> getBagsFrom(String rules, String splitter) {
        List<Bag> bags = new ArrayList<>();
        for (String rule : rules.split(splitter)) {
            String[] ruleParts = rule.split(" bags contain ");
            String name = ruleParts[0];
            List<String> otherBagsRules = Arrays.asList(ruleParts[1].split(", "));
            if (otherBagsRules.size() == 1 && otherBagsRules.get(0).contains("no other bags")) {
                Bag bag = new Bag(name);
                bags.add(bag);
            } else {
                Bag bag = new Bag(name);
                bags.add(bag);
                for (String otherBagRule : otherBagsRules) {
                    String otherBagRuleString = otherBagRule.replace(".", "");
                    String[] parts = otherBagRuleString.split(" ");
                    int amount = Integer.parseInt(parts[0]);
                    String color = String.format("%s %s", parts[1], parts[2]);
                    for (int i = 0; i < amount; i++) {
                        Bag hasbag = new Bag(color);
                        bag.bags.add(hasbag);
                    }
                }
            }
        }

        return bags;
    }

    public static int findBagWhichWillContain(String color, List<Bag> bags) {
        Set<String> result = new HashSet<>();
        tempResult = result.size();
        Set<String> colors = new HashSet<>();
        colors.add(color);
        findBagsContaining(colors, bags, result);
        return result.size();
    }

    private static void findBagsContaining(Set<String> colors, List<Bag> bags, Set<String> result) {
        for (Bag bag: bags) {
            for (String color: colors){
                var found = bag.bags.stream().filter(b->b.color.equals(color)).findFirst().orElse(null);
                if (found!=null){
                    result.add(bag.color);
                }
            }

        }
        if (tempResult != result.size()) {
            tempResult = result.size();
            Set<String> copyResult = new HashSet<>(result);
            findBagsContaining(copyResult,bags,result);
        }
    }

    public static Bag findRulesBagWithColor(String color, List<Bag> bags) {
        return bags.stream().filter(b->b.color.equals(color)).findFirst().orElse(null);
    }

    public static Bag createWholeBag(String color, List<Bag> rules) {
        Bag bag = new Bag(color, rules);
        return bag;
    }

    public static int getTotalBagsFrom(Bag bag) {
        bagCounter += bag.bags.size();
        for (Bag b: bag.bags){
            getTotalBagsFrom(b);
        }
        return bagCounter;
    }
}
