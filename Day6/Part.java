package Day6;

public class Part
{
    protected static boolean containsDuplicates(String string)
    {
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                if (!(i == j) && string.charAt(i) == string.charAt(j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int findStartIndex(String data, int markerSize)
    {
        for (int i = markerSize; i <= data.length(); i++) {
            String checkString = data.substring(i - markerSize, i);

            if (!containsDuplicates(checkString)) {
                return i;
            }
        }

        return -1;
    }
}
