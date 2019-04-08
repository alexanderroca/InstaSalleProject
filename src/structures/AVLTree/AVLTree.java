package structures.AVLTree;

import structures.Exceptions.NodeAlreadyExists;

public class AVLTree {
    private NodeAVL root;

    // Function to get the height of the tree
    public int height(NodeAVL n){
        if(n == null)
            return 0;
        return n.getHeight();
    }

    // Get the maximum of two integers
    public int max(int a, int b){
        return (a > b) ? a : b;
    }

    // Get the Balance Factor of NodeAVL n
    public int getBalance(NodeAVL n){
        if(n == null)
            return 0;
        return (height(n.getLeft()) - height(n.getRight()));
    }

    // PreOrder
    public void preOrder(NodeAVL n){
        if(n == null)
            return;
        System.out.print(n.getKey() + " ");
        preOrder(n.getLeft());
        preOrder(n.getRight());
    }

    // InOrder
    public void inOrder(NodeAVL n){
        if(n == null)
            return;
        inOrder(n.getLeft());
        System.out.print(n.getKey() + " ");
        inOrder(n.getRight());
    }

    //PostOrder
    public void postOrder(NodeAVL n){
        if(n == null)
            return;
        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.print(n.getKey() + " ");
    }

    // LL ROTATION
    public NodeAVL rightRotate(NodeAVL n){
        NodeAVL left = n.getLeft();
        NodeAVL left_right = left.getRight();

        left.setRight(n);
        n.setLeft(left_right);

        n.setHeight(max(height(n.getLeft()), height(n.getRight())) + 1);
        left.setHeight(max(height(left.getLeft()), height(left.getRight())) + 1);

        return left;
    }

    // RR ROTATION
    public NodeAVL leftRotate(NodeAVL n){
        NodeAVL right = n.getRight();
        NodeAVL right_left = right.getLeft();

        right.setLeft(n);
        n.setRight(right_left);

        n.setHeight(max(height(n.getLeft()), height(n.getRight())) + 1);
        right.setHeight(max(height(right.getLeft()), height(right.getRight())) + 1);

        return right;
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

    // Insertion of a new NodeAVL to the AVL Tree
    public NodeAVL insert(NodeAVL n, int key, Object object) throws NodeAlreadyExists{

        if (n == null)
            return (new NodeAVL(key, object)); //TODO: Determine what type of object to keep

        else {
            if (n.getKey() == key)
                throw new NodeAlreadyExists();

            // Insertion
            if (key < n.getKey()) {
                n.setLeft(insert(n.getLeft(), key, object));
            }   //if
            else if (key > n.getKey()) {
                n.setRight(insert(n.getRight(), key, object));
            }   //else-if
            else {
                return n;
            }   //else

            // Update heights
            n.setHeight(1 + max(height(n.getLeft()), height(n.getRight())));

            // Check if is balanced with the Balance Factor
            int balance = getBalance(n);
            // 4 possibles types of unbalanced
            //RR
            if (balance > 1 && key < n.getLeft().getKey())
                return rightRotate(n);
            //LL
            if (balance < -1 && key > n.getRight().getKey())
                return leftRotate(n);
            //LR
            if (balance > 1 && key > n.getLeft().getKey()) {
                n.setLeft(leftRotate(n.getLeft()));
                return rightRotate(n);
            }   //if
            //RL
            if (balance < -1 && key < n.getRight().getKey()) {
                n.setRight(rightRotate(n.getRight()));
                return leftRotate(n);
            }   //if
        }   //else
        return n;
    }

    public NodeAVL getRoot() {
        return root;
    }

    public void setRoot(NodeAVL root) {
        this.root = root;
    }
}
