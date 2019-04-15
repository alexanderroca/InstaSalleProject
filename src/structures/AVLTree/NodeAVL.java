package structures.AVLTree;

public class NodeAVL {
    private int key;
    private int height;
    private NodeAVL right;
    private NodeAVL left;
    private NodeAVL parent;
    private Object object;
    private boolean active;

    public NodeAVL(int key, Object object) {
        this.key = key;
        height = 1;
        active = true;
        this.object = object;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public NodeAVL getRight() {
        return right;
    }

    public void setRight(NodeAVL right) {
        this.right = right;
    }

    public NodeAVL getLeft() {
        return left;
    }

    public void setLeft(NodeAVL left) {
        this.left = left;
    }

    public NodeAVL getParent() {
        return parent;
    }

    public void setParent(NodeAVL parent) {
        this.parent = parent;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
