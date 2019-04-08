package structures.RedBlackTree;

public class NodeRBT {
    private int key;
    private Object object;
    private NodeRBT left;
    private NodeRBT right;
    private NodeRBT parent;
    private boolean color;  // Red = true, Black = false

    public NodeRBT(int key, Object object) {
        this.key = key;
        this.object = object;
        color = true;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public NodeRBT getLeft() {
        return left;
    }

    public void setLeft(NodeRBT left) {
        this.left = left;
    }

    public NodeRBT getRight() {
        return right;
    }

    public void setRight(NodeRBT right) {
        this.right = right;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public NodeRBT getParent() {
        return parent;
    }

    public void setParent(NodeRBT parent) {
        this.parent = parent;
    }
}
