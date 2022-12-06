package Day6;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class Day6
{
    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(new File("src/Day6/data.txt"));

            if (!scanner.hasNextLine()) {
                System.out.println("Error: the file does not have data");
                return;
            }

            String encodedMessage = scanner.nextLine();
            System.out.println("Part 1: " + Part.findStartIndex(encodedMessage, 4));
            System.out.println("Part 2: " + Part.findStartIndex(encodedMessage, 14));
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
