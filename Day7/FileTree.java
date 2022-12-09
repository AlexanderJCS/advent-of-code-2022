package Day7;

import java.util.ArrayList;

public class FileTree
{
    private final Directory rootDir = new Directory("/");
    private Directory currentDir = rootDir;
    private String pwd = "/";

    public void upDirectory()
    {
        // You cannot go up a directory
        if (pwd.equals("/")) {
            System.out.println("A fatal error occurred. You cannot go up from root directory");
            System.out.println(1);
        }

        int upperDirIndex = pwd.lastIndexOf('/');
        pwd = pwd.substring(0, upperDirIndex);

        currentDir = rootDir;

        for (String dirName : pwd.split("/")) {
            if (!dirName.equals("")) {
                currentDir = currentDir.getSubdir(dirName);
            }
        }
    }

    public void downDirectory(String dirName)
    {
        if (!currentDir.containsDirectory(dirName)) {
            currentDir.addSubdir(new Directory(dirName));
        }

        if (!pwd.equals("/")) {
            pwd += "/" + dirName;
        }

        else {
            pwd += dirName;
        }

        currentDir = currentDir.getSubdir(dirName);
    }

    public void addFile(int size)
    {
        currentDir.addFile(size);
    }

    ArrayList<Directory> getAllDirs(Directory directory)
    {
        ArrayList<Directory> dirs = new ArrayList<>();

        for (Directory subdir : directory.subdirs()) {
            dirs.add(subdir);
            dirs.addAll(getAllDirs(subdir));
        }

        return dirs;
    }

    /**
     * For part 1 of the problem
     */
    public int part1()
    {
//        return rootDir.getSizePart1(1);
        ArrayList<Directory> allDirs = getAllDirs(rootDir);

        int totalSize = 0;

        for (Directory dir : allDirs) {
            int size = dir.recursiveSize();

            // System.out.println("Size of " + dir.name + ": " + size);

            if (size <= 100000) {
                // System.out.println("Adding " + dir.name + " to totalSize");
                totalSize += size;
            }
        }

        return totalSize;
    }

    public int part2()
    {
        int spaceUnused = 70000000 - rootDir.recursiveSize();
        int sizeToDelete = 30000000 - spaceUnused;

        ArrayList<Directory> allDirs = getAllDirs(rootDir);
        allDirs.add(rootDir);

        int closest = Integer.MAX_VALUE;

        for (Directory dir : allDirs) {
            int size = dir.recursiveSize();

            if (size < sizeToDelete) {
                continue;
            }

            if (size - sizeToDelete < closest){
                closest = size;
            }
        }

        return closest;
    }
}
