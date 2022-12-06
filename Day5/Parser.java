package Day5;

import java.util.ArrayList;
import java.util.Scanner;


public class Parser
{
    /**
     * Not sure how to describe this, so I'll just put an example:
     *         [J] [N] [D]
     * turns into
     * [' ', ' ', 'J', 'N', 'D']
     */
    private static ArrayList<Character> splitString(String string)
    {
        ArrayList<Character> returnList = new ArrayList<>();

        ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i <= string.length() / 4; i++) {
            temp.add(string.substring(i * 4, i * 4 + 3));
        }

        for (String item : temp) {
            returnList.add(item.charAt(1));
        }

        return returnList;
    }

    public static ArrayList<ArrayList<Character>> parseFile(Scanner scanner)
    {
        ArrayList<ArrayList<Character>> parsed = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            /*
            If this condition is true the parser reached the point where the scanner is at the line
            which gives the numbers. This means that the next line will be move instructions, so stop here.
             */
            if (!line.contains("[")) {
                break;
            }

            ArrayList<Character> split = splitString(line);

            for (int i = 0; i < split.size(); i++) {
                if (parsed.size() <= i) {
                    parsed.add(new ArrayList<>());
                }

                if (split.get(i) == ' ') {
                    continue;
                }

                parsed.get(i).add(split.get(i));
            }
        }

        return parsed;
    }
}
