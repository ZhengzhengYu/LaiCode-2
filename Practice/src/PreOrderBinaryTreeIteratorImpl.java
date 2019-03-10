import java.util.*;

//http://n00tc0d3r.blogspot.com/2013/08/implement-iterator-for-binarytree-ii.html
public class PreOrderBinaryTreeIteratorImpl implements PreOrderBinaryTreeIterator {
    Deque<TreeNode> stack = new ArrayDeque<>();

    public PreOrderBinaryTreeIteratorImpl(TreeNode root) {
        if (root != null) {
            stack.offerFirst(root);
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("all node has been visited.");
        }
        TreeNode poll = stack.pollFirst();
        if (poll.right != null) {
            stack.offerFirst(poll.right);
        }
        if (poll.left != null) {
            stack.offerFirst(poll.left);
        }
        return poll.key;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported.");
    }

}
