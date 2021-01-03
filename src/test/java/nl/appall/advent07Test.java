package nl.appall;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class advent07Test {

    @Test
    public void advent07Created() {
        assertNotNull(advent07.class);
        assertNotNull(Bag.class);
    }

    @Test
    public void createBagsFromRuleList() {
        String rules = "light red bags contain 1 bright white bag, 2 muted yellow bags.\n" +
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
                "bright white bags contain 1 shiny gold bag.\n" +
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
                "faded blue bags contain no other bags.\n" +
                "dotted black bags contain no other bags.";
        List<Bag> bags = advent07.getBagsFrom(rules, ".\n");
        System.out.println(bags);
        var light_red = bags.stream().filter(b->b.color.equals("light red")).findFirst().get();
        var faded_blue = bags.stream().filter(b->b.color.equals("faded blue")).findFirst().get();
        var vibrant_plum = bags.stream().filter(b->b.color.equals("vibrant plum")).findFirst().get();
        assertEquals(3, light_red.bags.size());
        assertEquals(0, faded_blue.bags.size());
        assertEquals(11, vibrant_plum.bags.size());
    }
    @Test
    public void findBag(){
        String rules = "light red bags contain 1 bright white bag, 2 muted yellow bags.\n" +
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
                "bright white bags contain 1 shiny gold bag.\n" +
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
                "faded blue bags contain no other bags.\n" +
                "dotted black bags contain no other bags.";
        List<Bag> bags = advent07.getBagsFrom(rules, ".\n");
        int found = advent07.findBagWhichWillContain("shiny gold", bags);
        assertEquals(4, found);
    }

    @Test
    public void tesPart2(){
        String rules = "light red bags contain 1 bright white bag, 2 muted yellow bags.\n" +
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
                "bright white bags contain 1 shiny gold bag.\n" +
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
                "faded blue bags contain no other bags.\n" +
                "dotted black bags contain no other bags.";
        List<Bag> ruleBags = advent07.getBagsFrom(rules, ".\n");
        Bag shinyGoldenRule = advent07.createWholeBag("shiny gold", ruleBags);
        assertNotNull(shinyGoldenRule);
        var sgr = shinyGoldenRule.getBags().size();
        for (Bag bag: shinyGoldenRule.bags){
            sgr += bag.bags.size();
        }
        assertEquals(32, sgr);
    }

    @Test
    public void tesPart3(){
        String rules = "shiny gold bags contain 2 dark red bags.\n" +
                "dark red bags contain 2 dark orange bags.\n" +
                "dark orange bags contain 2 dark yellow bags.\n" +
                "dark yellow bags contain 2 dark green bags.\n" +
                "dark green bags contain 2 dark blue bags.\n" +
                "dark blue bags contain 2 dark violet bags.\n" +
                "dark violet bags contain no other bags.";
        List<Bag> ruleBags = advent07.getBagsFrom(rules, ".\n");
        Bag shinyGoldenRule = advent07.createWholeBag("shiny gold", ruleBags);
        assertNotNull(shinyGoldenRule);

        advent07.bagCounter = 0;
        int result = advent07.getTotalBagsFrom(shinyGoldenRule);
        assertEquals(126, result);
    }
}
