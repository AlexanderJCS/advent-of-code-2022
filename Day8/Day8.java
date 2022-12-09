package Day8;


import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class Day8
{
    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(new File("src/Day8/data.txt"));
            Integer[][] parsed = FileParser.parseFile(scanner);
            System.out.println("Part 1: " + Part1.getTreesVisible(parsed));
            System.out.println("Part 2: " + Part2.getMaxScenicScore(parsed));
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
