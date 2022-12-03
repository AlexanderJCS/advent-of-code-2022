package Day3;

import java.util.Scanner;

public class Part2 extends Part1
{
    private static char commonLetter(String rucksack1, String rucksack2, String rucksack3)
    {
        for (char chr1 : rucksack1.toCharArray()) {
            for (char chr2 : rucksack2.toCharArray()) {
                for (char chr3: rucksack3.toCharArray()) {
                    if (chr1 == chr2 && chr2 == chr3) {
                        return chr1;
                    }
                }
            }
        }

        return Character.MIN_VALUE;
    }

    public static int findGroupSum(Scanner scanner)
    {
        int groupSum = 0;

        while (scanner.hasNextLine())
        {
            String[] elfRucksacks = new String[3];

            for (int i = 0; i < elfRucksacks.length; i++) {
                elfRucksacks[i] = scanner.nextLine();
            }

            char commonLetter = commonLetter(elfRucksacks[0], elfRucksacks[1], elfRucksacks[2]);
            groupSum += getPriorityValue(commonLetter);
        }

        return groupSum;
    }
}
