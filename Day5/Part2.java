package Day5;

import java.util.ArrayList;
import java.util.Scanner;

public class Part2 extends Part1
{
    public static void executeInstructions(
            ArrayList<ArrayList<Character>> crates, Scanner scanner)
    {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Instruction instruction = getInstruction(line);

            if (instruction == null) {
                continue;
            }

            for (int i = instruction.count - 1; i >= 0; i--) {
                char removed = crates.get(instruction.fromIndex).remove(i);
                crates.get(instruction.toIndex).add(0, removed);
            }
        }
    }
}
