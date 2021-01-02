package nl.appall;

import java.util.ArrayList;

public class advent03 {

    private static ArrayList<String> lines = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        lines = FileIOHelper.ReadValuesIn("03 - treemap.txt");
        System.out.println("Solutions for day 3\n");
        System.out.println(String.format("lines %d", lines.size()));
        findSolutionOne(lines);
        findSolutionTwo(lines);
    }

    private static void findSolutionTwo(ArrayList<String> lines) {
        ArrayList<Long> results = new ArrayList<>();
        long trees = advent03.stepThrough(lines, 1, 1);
        results.add(trees);

        trees = advent03.stepThrough(lines, 3, 1);
        results.add(trees);

        trees = advent03.stepThrough(lines, 5, 1);
        results.add(trees);

        trees = advent03.stepThrough(lines, 7, 1);
        results.add(trees);

        trees = advent03.stepThrough(lines, 1, 2);
        results.add(trees);
        long total = results.stream().reduce(1L, (a, b) -> a * b);

        System.out.println(String.format("Second Puzzle Found %d",total));
    }

    private static void findSolutionOne(ArrayList<String> lines) {
        int result = stepThrough(lines,3,1);
        if (result==-1) System.out.println("found nothing...");
        System.out.println(String.format("First Puzzle Found %d",result));
    }

    public static int stepThrough(ArrayList<String> lines, int right, int down) {
        int x = right;
        int y = down;
        int heightPuzzle = lines.size();
        int widthPuzzle = lines.get(0).split("").length;
        int trees = 0;
        while ((y < heightPuzzle)){
            String positionY = lines.get(y);
            String[] line = positionY.split("");
            String positionX = line[x];
//            System.out.print(positionX.equals(".")?"0":"X");
            if (positionX.equals("#")) trees++;
            x = (x + right) % widthPuzzle;
            y += down;
        }

        return trees;
    }

}

