package Day2;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Day2
{
    public static void main(String[] args)
    {
        try {
            Scanner partOneScanner = new Scanner(new File("src/Day2/data.txt"));
            System.out.println("Part 1: " + Part1.getTotalPoints(partOneScanner));

            Scanner partTwoScanner = new Scanner(new File("src/Day2/data.txt"));
            System.out.println("Part 2: " + Part2.getTotalPoints(partTwoScanner));
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
