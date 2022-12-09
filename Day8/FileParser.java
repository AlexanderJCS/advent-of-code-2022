package Day8;

import java.util.ArrayList;
import java.util.Scanner;


public class FileParser
{
    public static Integer[][] parseFile(Scanner scanner)
    {
        ArrayList<ArrayList<Integer>> trees = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineSplit = line.split("");

            trees.add(new ArrayList<>());

            for (String item : lineSplit) {
                trees.get(trees.size() - 1).add(Integer.parseInt(item));
            }
        }

        /*
        Honestly no idea how this line works
        Just look at this StackOverflow thread if you want to know:
        https://stackoverflow.com/questions/10043209/convert-arraylist-into-2d-array-containing-varying-lengths-of-arrays
         */
        return trees.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
    }
}
