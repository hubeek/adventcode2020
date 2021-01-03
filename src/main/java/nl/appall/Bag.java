package nl.appall;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Bag {
    String color;
    public List<Bag> bags = new ArrayList<>();

    Bag(String color) {
        this.color = color;
    }

    Bag(String color, List<Bag> rules){
        this.color = color;
        Bag bagrule = rules.stream().filter(b->b.color.equals(color)).findFirst().orElse(null);
        createBagsFrom(rules, bagrule.bags);
    }

    private void createBagsFrom(List<Bag> rules, List<Bag> bags) {
        for (Bag bag: bags) {
            Bag findRule = rules.stream().filter(b->b.color.equals(bag.color)).findFirst().orElse(null);
            Bag newBag = new Bag(findRule.color, rules);
            this.bags.add(newBag);
        }
    }




    private void addBags(List<Bag> bags) {
        this.bags = Stream.concat(this.bags.stream(), bags.stream())
                .collect(Collectors.toList());
    }

    private List<Bag> createBags(int amount, String color) {
        List<Bag> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Bag fbBag = new Bag(color);
            result.add(fbBag);
        }
        return result;
    }

    public List<Bag> getBags() {
        return bags;
    }

    public void setBags(List<Bag> bags) {
        this.bags = bags;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "color='" + color + '\'' +
                ", bags=" + bags.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bag)) return false;
        Bag bag = (Bag) o;
        return getColor().equals(bag.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor());
    }
}
