package Day8;

public class Part1
{
    private static boolean visible(int treeX, int treeY, Integer[][] trees)
    {
        // If it's at the edge it is visible
        if (treeX == 0 || treeX == trees[treeY].length - 1 ||
                treeY == 0 || treeY == trees.length - 1)
        {
            return true;
        }

        boolean broken = false;

        for (int y = 0; y < treeY; y++) {
            if (trees[y][treeX] >= trees[treeY][treeX]) {
                broken = true;
                break;
            }
        }

        // Tree is visible in the upwards direction
        if (!broken) {
            return true;
        }

        broken = false;

        for (int y = trees.length - 1; y > treeY; y--) {
            if (trees[y][treeX] >= trees[treeY][treeX]) {
                broken = true;
                break;
            }
        }

        // Tree is visible in the downwards direction
        if (!broken) {
            return true;
        }

        broken = false;

        for (int x = 0; x < treeX; x++) {
            if (trees[treeY][x] >= trees[treeY][treeX]) {
                broken = true;
                break;
            }
        }

        // Tree is visible in the leftwards direction
        if (!broken) {
            return true;
        }

        broken = false;

        for (int x = trees[treeY].length - 1; x > treeX; x--) {
            if (trees[treeY][x] >= trees[treeY][treeX]) {
                broken = true;
                break;
            }
        }

        // Tree is visible in the rightwards direction
        return !broken;
    }

    public static int getTreesVisible(Integer[][] trees)
    {
        int visible = 0;

        for (int y = 0; y < trees.length; y++) {
            for (int x = 0; x < trees[y].length; x++) {
                if (visible(x, y, trees)) {
                    visible++;
                }
            }
        }

        return visible;
    }
}
