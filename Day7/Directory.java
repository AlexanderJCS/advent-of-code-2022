package Day7;

import java.util.ArrayList;
import java.util.HashMap;


public class Directory
{
    private final HashMap<String, Directory> subdirectories;
    private final ArrayList<Integer> fileSizes;
    public final String name;

    Directory(String name)
    {
        this.name = name;
        this.subdirectories = new HashMap<>();
        this.fileSizes = new ArrayList<>();
    }

    public void addFile(int size)
    {
        fileSizes.add(size);
    }

    public void addSubdir(Directory directory)
    {
        subdirectories.put(directory.name, directory);
    }

    public boolean containsDirectory(String name)
    {
        return subdirectories.containsKey(name);
    }

    public Directory getSubdir(String dirName)
    {
        return subdirectories.get(dirName);
    }

    public java.util.Collection<Directory> subdirs()
    {
        return subdirectories.values();
    }

    public int dirSize()
    {
        int totalSize = 0;

        for (Integer size : fileSizes) {
            totalSize += size;
        }

        return totalSize;
    }

    public int recursiveSize()
    {
        int totalSize = dirSize();

        for (var subdirectory : subdirectories.values()) {
            totalSize += subdirectory.recursiveSize();
        }

        return totalSize;
    }
}
