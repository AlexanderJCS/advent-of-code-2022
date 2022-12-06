package Day5;

public class Instruction
{
    public final int count;
    public final int fromIndex;
    public final int toIndex;

    Instruction(int count, int fromIndex, int toIndex)
    {
        this.count = count;
        this.fromIndex = fromIndex - 1;
        this.toIndex = toIndex - 1;
    }
}
