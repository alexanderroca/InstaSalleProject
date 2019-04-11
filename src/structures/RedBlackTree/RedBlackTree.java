package structures.RedBlackTree;

import structures.NodeAlreadyExists;

public class RedBlackTree {
    public static boolean RED = true;
    public static boolean BLACK = false;
    private NodeRBT root;

    // Check color NodeRBT is RED
    public boolean isRed(NodeRBT n){
        if(n == null)
            return false;
        return n.isColor() == RED;
    }

    // Check color NodeRBT is BLACK
    public boolean isBlack(NodeRBT n){
        if(n == null)
            return false;
        return n.isColor() == BLACK;
    }

    // PreOrder
    public void preOrder(NodeRBT n){
        if(n == null)
            return;
        System.out.print(n.getKey() + " ");
        preOrder(n.getLeft());
        preOrder(n.getRight());
    }

    // InOrder
    public void inOrder(NodeRBT n){
        if(n == null)
            return;
        inOrder(n.getLeft());
        System.out.print(n.getKey() + " ");
        inOrder(n.getRight());
    }

    //PostOrder
    public void postOrder(NodeRBT n){
        if(n == null)
            return;
        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.print(n.getKey() + " ");
    }

    // LL ROTATION
    public NodeRBT rightRotate(NodeRBT n){
        NodeRBT left = n.getLeft();
        NodeRBT left_right = left.getRight();

        left.setRight(n);
        n.setLeft(left_right);

        return left;
    }

    // RR ROTATION
    public NodeRBT leftRotate(NodeRBT n){
        NodeRBT right = n.getRight();
        NodeRBT right_left = right.getLeft();

        right.setLeft(n);
        n.setRight(right_left);

        return right;
    }

    public void swapColors(NodeRBT n1, NodeRBT n2){
        boolean aux = n1.isColor();
        n1.setColor(n2.isColor());
        n2.setColor(aux);
    }

    public boolean insert_T(int key, Object object){

        try {
            root = insert(root, key, object);
            return true;
        } catch (NodeAlreadyExists nodeAlreadyExists) {
            System.out.println(nodeAlreadyExists.getMessage() + key);
            return false;
        }
    }

    // Insertion of a new NodeRBT to the RED-BLACK Tree
    public NodeRBT insert(NodeRBT n, int key, Object object) throws NodeAlreadyExists {
        if (n == null)
            return (new NodeRBT(key, null)); //TODO: Determine what type of object to keep
        else {
            if (n.getKey() == key)
                throw new NodeAlreadyExists();

            // Insertion
            if (key < n.getKey()) {
                n.setLeft(insert(n.getLeft(), key, object));
                n.getLeft().setParent(n);
            }   //if
            else if (key > n.getKey()) {
                n.setRight(insert(n.getRight(), key, object));
                n.getRight().setParent(n);
            }   //else-if
            else {
                return n;
            }   //else
        }   //else

        // Right child is RED but left child is BLACK or doesn't exist
        if(isRed(n.getRight()) && !isRed(n.getLeft())){
            n = leftRotate(n);
            swapColors(n, n.getLeft());
        }   //if

        // Child and parent are REDs
        if(isRed(n.getLeft()) && isRed(n.getLeft().getLeft())){
            n = rightRotate(n);
            swapColors(n, n.getRight());
        }   //if

        // Both childs are RED
        if(isRed(n.getLeft()) && isRed(n.getRight())){
            n.setColor(!n.isColor());
            n.getLeft().setColor(BLACK);
            n.getRight().setColor(BLACK);
        }   //if

        root.setColor(BLACK);

        return n;
    }

    public NodeRBT getRoot() {
        return root;
    }

    public void setRoot(NodeRBT root) {
        this.root = root;
    }
}
