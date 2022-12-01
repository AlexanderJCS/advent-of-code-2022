package Day1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class Day1
{
    private static final String FILEPATH = "src/Day1/data.txt";

    public static ArrayList<Integer> getCaloriesSorted(Path path) throws IOException
    {
        List<String> lines = Files.readAllLines(path);

        ArrayList<ArrayList<Integer>> calories = new ArrayList<>();
        calories.add(new ArrayList<>());

        for (String line : lines)
        {
            // a separate elf is distinguished by a blank line
            // so if there's a blank line create a new elf
            if (line.trim().isEmpty()) {
                calories.add(new ArrayList<>());
                continue;
            }

            Integer caloriesInt = Integer.parseInt(line);
            calories.get(calories.size() - 1).add(caloriesInt);
        }

        // the total number of calories per elf
        ArrayList<Integer> caloriesAdded = new ArrayList<>();

        for (ArrayList<Integer> elf : calories) {
            Integer totalCalories = 0;

            for (Integer snackCalories : elf) {
                totalCalories += snackCalories;
            }

            caloriesAdded.add(totalCalories);
        }

        caloriesAdded.sort(Collections.reverseOrder());
        return caloriesAdded;
    }

    public static void main(String[] args)
    {
        try {
            Path path = Path.of(FILEPATH);
            ArrayList<Integer> caloriesAdded = getCaloriesSorted(path);

            System.out.println("Part 1: " + caloriesAdded.get(0));
            System.out.println("Part 2: " + caloriesAdded.subList(0, 3));
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
