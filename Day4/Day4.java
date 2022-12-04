package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Day4
{
    public static ArrayList<ElfAssignment[]> parseAssignments(Scanner scanner)
    {
        ArrayList<ElfAssignment[]> assignments = new ArrayList<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] ids = line.split(",");

            if (ids.length != 2) {
                System.out.println("Error parsing line " + line + ": " + Arrays.toString(ids));
                System.exit(1);
            }

            ElfAssignment[] entry = { new ElfAssignment(ids[0]), new ElfAssignment(ids[1]) };
            assignments.add(entry);
        }

        return assignments;
    }

    public static int findNumFullyContains(ArrayList<ElfAssignment[]> elfAssignments)
    {
        int fullyContains = 0;

        for (ElfAssignment[] pair : elfAssignments) {
            if (pair[0].startID >= pair[1].startID && pair[0].endID <= pair[1].endID ||
                    pair[1].startID >= pair[0].startID && pair[1].endID <= pair[0].endID) {
                fullyContains++;
            }
        }

        return fullyContains;
    }

    public static int findNumOverlap(ArrayList<ElfAssignment[]> elfAssignments)
    {
        int overlaps = 0;

        for (ElfAssignment[] pair : elfAssignments) {
            boolean overlapped = false;

            for (int i : IntStream.range(pair[0].startID, pair[0].endID + 1).toArray()) {
                for (int j : IntStream.range(pair[1].startID, pair[1].endID + 1).toArray()) {
                    if (i == j) {
                        overlaps++;
                        overlapped = true;
                        break;
                    }
                }

                if (overlapped) {
                    break;
                }
            }
        }

        return overlaps;
    }

    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(new File("src/Day4/data.txt"));

            ArrayList<ElfAssignment[]> elfAssignments = parseAssignments(scanner);
            System.out.println("Part 1: " + findNumFullyContains(elfAssignments));
            System.out.println("Part 2: " + findNumOverlap(elfAssignments));
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
