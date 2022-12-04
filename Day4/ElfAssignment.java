package Day4;

import java.util.Arrays;

public class ElfAssignment
{
    public final int startID;
    public final int endID;

    ElfAssignment(String range)
    {
        String[] startEnd = range.split("-");

        if (startEnd.length != 2) {
            System.out.println("Error parsing " + range + ": " + Arrays.toString(startEnd));
            System.exit(1);
        }

        startID = Integer.parseInt(startEnd[0]);
        endID = Integer.parseInt(startEnd[1]);
    }
}
