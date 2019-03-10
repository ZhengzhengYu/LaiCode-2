import java.util.Iterator;

public interface PreOrderBinaryTreeIterator extends Iterator<Integer> {
    public Integer next();
    public boolean hasNext();
}
