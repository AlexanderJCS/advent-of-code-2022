package Day2;

import java.util.HashMap;
import java.util.Scanner;


public class Part2 extends Part1
{
    // Key: opponent's move
    // Value: what move you need to win
    private static final HashMap<Character, Character> winMap = new HashMap<>() {{
        put('A', 'B');
        put('B', 'C');
        put('C', 'A');
    }};

    // Key: opponent's move
    // Value: what move you need to lose
    private static final HashMap<Character, Character> loseMap = new HashMap<>() {{
        put('A', 'C');
        put('B', 'A');
        put('C', 'B');
    }};

    private static char getMoveFromOutcome(char opponentMove, char desiredOutcome)
    {
        return switch (desiredOutcome) {
            case 'Y' -> opponentMove; // Draw
            case 'X' -> loseMap.get(opponentMove);  // Lose
            case 'Z' -> winMap.get(opponentMove);  // Win
            default -> ' ';
        };
    }

    public static int getTotalPoints(Scanner scanner)
    {
        int points = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            char outcome = line.charAt(2);
            char opponentMove = line.charAt(0);

            points += getPoints((char) (getMoveFromOutcome(opponentMove, outcome) + 23), opponentMove);
        }

        return points;
    }
}
