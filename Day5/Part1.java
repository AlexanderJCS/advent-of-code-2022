package Day5;

import java.util.ArrayList;
import java.util.Scanner;


public class Part1
{
    protected static Instruction getInstruction(String instructionString)
    {
        String[] split = instructionString.split(" ");

        if (split.length != 6) {
            return null;
        }

        return new Instruction(Integer.parseInt(split[1]), Integer.parseInt(split[3]), Integer.parseInt(split[5]));
    }

    public static void executeInstructions(
            ArrayList<ArrayList<Character>> crates, Scanner scanner)
    {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Instruction instruction = getInstruction(line);

            if (instruction == null) {
                continue;
            }

            for (int i = 0; i < instruction.count; i++) {
                char removed = crates.get(instruction.fromIndex).remove(0);
                crates.get(instruction.toIndex).add(0, removed);
            }
        }
    }
}
