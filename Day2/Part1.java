package Day2;

import java.util.HashMap;
import java.util.Scanner;

public class Part1
{
    // key: move, value: what it beats
    private static final HashMap<Character, Character> winRules = new HashMap<>() {{
        put('A', 'C');
        put('B', 'A');
        put('C', 'B');
    }};

    static int getPoints(char yourMove, char opponentMove)
    {
        // Subtract yourMove by 23 so X = A, Y = B, and Z = C
        yourMove = (char) (yourMove - 23);

        int movePoints = yourMove - 'A' + 1;

        // Tie
        if (yourMove == opponentMove) {
            return movePoints + 3;
        }

        // Win
        if (winRules.get(yourMove) == opponentMove) {
            return movePoints + 6;
        }

        // Loss
        else {
            return movePoints;
        }
    }

    public static int getTotalPoints(Scanner scanner)
    {
        int points = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            char yourMove = line.charAt(2);
            char opponentMove = line.charAt(0);

            points += getPoints(yourMove, opponentMove);
        }

        return points;
    }
}
