package Day7;

import java.util.Scanner;


public class FileParser
{
    public static FileTree getTree(Scanner scanner)
    {
        FileTree tree = new FileTree();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.equals("$ ls") || line.contains("dir") || line.equals("$ cd /")) {
                continue;
            }

            if (line.equals("$ cd ..")) {
                tree.upDirectory();
            }

            else if (line.contains("$ cd")) {
                String[] split = line.split(" ");
                tree.downDirectory(split[split.length - 1]);
            }

            // This must be a file since the first condition
            // skips lines with "dir" in them
            else if (line.charAt(0) != '$') {
                String[] split = line.split(" ");
                tree.addFile(Integer.parseInt(split[0]));
            }
        }

        return tree;
    }
}
