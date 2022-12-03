package Day3;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Day3
{
    public static void main(String[] args)
    {
        try {
            Scanner fileScanner = new Scanner(new File("src/Day3/data.txt"));

            System.out.println("Part 1: " + Part1.getPrioritySum(fileScanner));

            fileScanner = new Scanner(new File("src/Day3/data.txt"));

            System.out.println("Part 2: " + Part2.findGroupSum(fileScanner));
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
