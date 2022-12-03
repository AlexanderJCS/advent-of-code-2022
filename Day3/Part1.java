package Day3;

import java.util.Scanner;

public class Part1
{
    static char getCommonLetter(String line)
    {
        int middle = line.length() / 2;

        String compartment1 = line.substring(0, middle);
        String compartment2 = line.substring(middle);

        for (char item1 : compartment1.toCharArray()) {
            for (char item2 : compartment2.toCharArray()) {
                if (item1 == item2) {
                    return item1;
                }
            }
        }

        return Character.MIN_VALUE;
    }

    static int getPriorityValue(char chr)
    {
        // if chr is lowercase
        if (chr >= 97) {
            return chr - 'a' + 1;
        }

        return chr - 'A' + 27;
    }

    public static int getPrioritySum(Scanner scanner)
    {
        int prioritySum = 0;

        while (scanner.hasNextLine()) {
            char commonLetter = getCommonLetter(scanner.nextLine());

            if (commonLetter == Character.MIN_VALUE) {
                continue;
            }

            prioritySum += getPriorityValue(commonLetter);
        }

        return prioritySum;
    }
}
