package Day7;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class Day7
{
    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(new File("src/Day7/data.txt"));
            FileTree tree = FileParser.getTree(scanner);
            System.out.println("Part 1: " + tree.part1());
            System.out.println("Part 2: " + tree.part2());
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
