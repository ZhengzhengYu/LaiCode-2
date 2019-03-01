public class TreeNodeP {
    int key;
    TreeNodeP left;
    TreeNodeP right;
    TreeNodeP parent;

    public TreeNodeP(int key, TreeNodeP parent) {
        this.key = key;
        this.parent = parent;
    }
}
