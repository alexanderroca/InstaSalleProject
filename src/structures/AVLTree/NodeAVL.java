package structures.AVLTree;

/**
 * Classe Node de l'arbre AVL
 * @author Alexander Roca
 * @version 0.1
 */
public class NodeAVL {
    private int key;    //identificador unic
    private int height; //altura del l'arbre
    private NodeAVL right;  //fill dret
    private NodeAVL left;   //fill esquerra
    private NodeAVL parent; //pare
    private Object object;  //element
    private boolean active;

    /**
     * Constructor que necessita l'identificador unic i l'element que contindra
     * @param key : int
     * @param object : Object
     */
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
