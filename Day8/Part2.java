package Day8;

public class Part2
{
    private static int scenicScore(int treeX, int treeY, Integer[][] trees)
    {
        int upScore = 1;

        for (int i = treeY - 1; i >= 0; i--) {
            if (trees[i][treeX] >= trees[treeY][treeX]) {
                break;
            }

            if (i != 0) {
                upScore++;
            }
        }

        int downScore = 1;

        for (int i = treeY + 1; i < trees.length; i++) {
            if (trees[i][treeX] >= trees[treeY][treeX]) {
                break;
            }

            if (i != trees.length - 1) {
                downScore++;
            }
        }

        int leftScore = 1;

        for (int i = treeX - 1; i >= 0; i--) {
            if (trees[treeY][i] >= trees[treeY][treeX]) {
                break;
            }

            if (i != 0) {
                leftScore++;
            }
        }

        int rightScore = 1;

        for (int i = treeX + 1; i < trees[treeY].length; i++) {
            if (trees[treeY][i] >= trees[treeY][treeX]) {
                break;
            }

            if (i != trees[treeY].length - 1) {
                rightScore++;
            }
        }

        return leftScore * rightScore * upScore * downScore;
    }

    public static int getMaxScenicScore(Integer[][] trees)
    {
        int maxScore = 0;

        for (int y = 0; y < trees.length; y++) {
            for (int x = 0; x < trees[y].length; x++) {
                int score = scenicScore(x, y, trees);

                if (score > maxScore) {
                    maxScore = score;
                }
            }
        }

        return maxScore;
    }
}
