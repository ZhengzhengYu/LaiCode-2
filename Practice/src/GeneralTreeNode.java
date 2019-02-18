import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    public int key;
    public List<TreeNode> children;
    //TreeNode parent;

    public GeneralTreeNode(int key) {
        this.key = key;
        children = new ArrayList<>();
    }
}
