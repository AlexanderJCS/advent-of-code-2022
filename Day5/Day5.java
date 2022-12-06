package Day5;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Day5
{
    private static void printPart(int partNum, ArrayList<ArrayList<Character>> crates)
    {
        System.out.print("\nPart " + partNum + ": ");
        for (ArrayList<Character> item : crates) {
            if (item.size() > 0) {
                System.out.print(item.get(0));
            }
        }
    }

    public static void main(String[] args)
    {
        try {
            Scanner scannerPart1 = new Scanner(new File("src/Day5/data.txt"));
            Scanner scannerPart2 = new Scanner(new File("src/Day5/data.txt"));
            ArrayList<ArrayList<Character>> cratesPart1 = Parser.parseFile(scannerPart1);
            ArrayList<ArrayList<Character>> cratesPart2 = Parser.parseFile(scannerPart2);

            Part1.executeInstructions(cratesPart1, scannerPart1);
            printPart(1, cratesPart1);


            Part2.executeInstructions(cratesPart2, scannerPart2);
            printPart(2, cratesPart2);
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
