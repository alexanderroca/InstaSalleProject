package structures.AVLTree;

import JsonObjects.Objects.Post;
import JsonObjects.Objects.User;
import structures.NodeAlreadyExists;
import structures.NodeDoesntExists;

import java.util.ArrayList;

/**
 * Classe amb les operacions basiques del arbre binari AVL
 * @author Alexander Roca
 * @version 0.1
 */
public class AVLTree{
    private NodeAVL root;

    private ArrayList to_export_posts = new ArrayList();

    /**
     * Funcio que obte l'alçada del arbre a partir d'un node
     * @param n : NodeAVL
     * @return int
     */
    public int height(NodeAVL n){
        if(n == null)
            return 0;
        return n.getHeight();
    }

    /**
     * Funcio que indica quin dels dos nombres es major
     * @param a : int
     * @param b : int
     * @return int
     */
    public int max(int a, int b){
        return (a > b) ? a : b; // Equivalent a fer if i else (es una ternaria)
    }

    /**
     * Funcio que obte el factor de balanceig a partir d'un node
     * @param n : NodeAVL
     * @return int
     */
    public int getBalance(NodeAVL n){
        if(n == null)
            return 0;
        return (height(n.getLeft()) - height(n.getRight()));
    }

    /**
     * Procediment que mostra els elements de l'arbre amb els criteris de PreOrder
     * @param n : NodeAVL
     */
    public void preOrder(NodeAVL n){
        if(n == null)
            return;
        System.out.print(n.getKey() + " ");
        preOrder(n.getLeft());
        preOrder(n.getRight());
    }

    // InOrder

    /**
     * Procediment que mostra els elements de l'arbre amb els criteris de InOrder
     * @param n : NodeAVL
     */
    public void inOrder(NodeAVL n){
        if(n == null)
            return;
        inOrder(n.getLeft());
        if(n.getObject() instanceof User) {
            System.out.println(((User) n.getObject()).getUsername());
        }
        else if(n.getObject() instanceof Post)
            System.out.println(((Post) n.getObject()).getId());
        inOrder(n.getRight());
    }

    public void toExport(NodeAVL n){

        if(n == null)
            return;
        toExport(n.getLeft());
        if(n.getObject() instanceof Post)
            to_export_posts.add(n.getObject());
        toExport(n.getRight());
    }

    //PostOrder

    /**
     * Procediment que mostra els elements de l'arbre amb els criteris de PostOrder
     * @param n : NodeAVL
     */
    public void postOrder(NodeAVL n){
        if(n == null)
            return;
        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.print(n.getKey() + " ");
    }

    /**
     * Funcio que realitza la rotacio de tipus LL quan es produeix un desbalanceig en l'arbre
     * @param n : NodeAVL
     * @return NodeAVL
     */
    public NodeAVL rightRotate(NodeAVL n){
        NodeAVL left = n.getLeft(); //Obtenim el fill esquerre
        NodeAVL left_right = left.getRight();   //Obtenim el fill dret del fill esquerre

        left.setRight(n);   //Sobreescrivim el fill dret amb el node que produeix el desbalanceig
        n.setLeft(left_right);  //Sobreescrivim el node on s'ha produit el desbalanceig com ha fill dret del fill esquerre

        n.setHeight(max(height(n.getLeft()), height(n.getRight())) + 1);    //Recalculem la nova alçada del node actual
        left.setHeight(max(height(left.getLeft()), height(left.getRight())) + 1);   //Recalculem ka nova alçada del fill esquerre

        return left;
    }

    /**
     * Funcio que realitza la rotacio de tipus RR quan es produeix un desbalanceig en l'arbre
     * @param n : NodeAVL
     * @return NodeAVL
     */
    public NodeAVL leftRotate(NodeAVL n){
        NodeAVL right = n.getRight();   //Obtenim el fill dret
        NodeAVL right_left = right.getLeft();   //Obtenim el fill esquerre del fill dret

        right.setLeft(n);   //Sobreescrivim el node esquerre amb el node que produeix el desbalanceig
        n.setRight(right_left); //Sobreescrivim el node on s'ha produit el desbalanceig com a fill esquerre del fill dret

        n.setHeight(max(height(n.getLeft()), height(n.getRight())) + 1);    //Recalculem la nova alçada del node actual
        right.setHeight(max(height(right.getLeft()), height(right.getRight())) + 1);    //Recalculem ka nova alçada del fill dret

        return right;
    }

    /**
     * Funcio que comprova si l'element a inserir no existeixi previament
     * @param key : int
     * @param object : Object
     * @return boolean
     */
    public boolean insert_T(int key, Object object){

        try {
            root = insert(root, key, object);
            return true;
        } catch (NodeAlreadyExists nodeAlreadyExists) {
            System.out.println(nodeAlreadyExists.getMessage() + key);
            return false;
        }
    }

    /**
     * Funcio que comprova si l'element a eliminarexisteix o no
     * @param key : int
     * @return boolean
     */
    public boolean remove_T(int key){
        try{
            root = remove(root, key);
            return true;
        } catch (NodeDoesntExists nodeDoesntExists){
            System.out.println(nodeDoesntExists.getMessage() + key);
            return false;
        }
    }

    /**
     * Funcio que realitza la cerca per l'arbre
     * @param n : NodeAVL
     * @param key : int
     * @return NodeAVL
     */
    public NodeAVL search(NodeAVL n, int key){

        if(n == null)
            return null;
        else if(key < n.getKey())
            return search(n.getLeft(), key);
        else if(key > n.getKey())
            return search(n.getRight(), key);
        else
            return n;
    }

    /**
     * Funcio que elimina l'element de l'estructura
     * @param n : NodeAVL
     * @param key : int
     * @return NodeAVL
     * @throws NodeDoesntExists
     */
    public NodeAVL remove(NodeAVL n, int key) throws NodeDoesntExists{

        //Cas de que el node que busquem sigui null
        if(n == null)
            throw new NodeDoesntExists();

        //Recorrem l'arbre fins trobar el node a eliminar
        if(key < n.getKey())
            n.setLeft(remove(n.getLeft(), key));
        else if(key > n.getKey())
            n.setRight(remove(n.getRight(), key));
        //Cas que cal eliminar l'element
        else{
            //Cas que el node a eliminar tingui 0 fills o 1 fill
            if(n.getLeft() == null || n.getRight() == null){

                NodeAVL aux = null;
                if(aux == n.getLeft())
                    aux = n.getRight();
                else
                    aux = n.getLeft();

                //Cas de 1 fill
                if(aux == null){
                    aux = n;
                    n = null;
                }   //if
                //Cas de 0 fills
                else
                    n = aux;
            }   //if
            //Cas de 2 fills
            else{
                NodeAVL aux = minValueNode(n.getRight());   //Realitzem un inOrder local, el successor sera el de l'esquerra
                n.setKey(aux.getKey()); //Copiem el successor del InOrder local al node actual
                n.setRight(remove(n.getRight(), aux.getKey())); //Eliminem el node successor de la seva antiga posicio
            }   //else
        }   //else

        //Cas en que l'arbre nomes tingues 1 node que retornar
        if(n == null)
            return n;

        n.setHeight(max(height(n.getLeft()), height(n.getRight())) + 1);    //Actualitzem l'alçada del node actual

        int balance = getBalance(n);    //Comprovem que no hi hagi desbalanceig
        //LL
        if(balance > 1 && getBalance(n.getLeft()) >= 0)
            return rightRotate(n);
        //LR
        if(balance > 1 && getBalance(n.getLeft()) < 0){
            n.setLeft(leftRotate(n.getLeft()));
            return rightRotate(n);
        }   //if
        //RR
        if(balance < -1 && getBalance(n.getRight()) <= 0)
            return leftRotate(n);
        //RL
        if(balance < -1 && getBalance(n.getRight()) > 0) {
            n.setRight(rightRotate(n.getRight()));
            return leftRotate(n);
        }   //if

        return n;
    }

    /**
     * Funcio que cerca l'identificador unic mes petit de l'arbre
     * @param n : NodeAVL
     * @return NodeAVL
     */
    public NodeAVL minValueNode(NodeAVL n){
        NodeAVL aux = n;

        //Bucle per trobar la fulla que esta més a l'esquerra
        while(aux.getLeft() != null)
            aux = aux.getLeft();

        return aux;
    }

    /**
     * Funcio que insereix un nou element a l'estructura
     * @param n : NodeAVL
     * @param key : int
     * @param object : Object
     * @return NodeAVL
     * @throws NodeAlreadyExists
     */
    public NodeAVL insert(NodeAVL n, int key, Object object) throws NodeAlreadyExists{

        //Inserim el nou element
        if (n == null)
            return (new NodeAVL(key, object));

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
            // Identificadors unics no son valids
            else {
                return n;
            }   //else

            // Actualitzem les noves alçades
            n.setHeight(1 + max(height(n.getLeft()), height(n.getRight())));

            // Comprova si el node esta balancejat
            int balance = getBalance(n);
            // 4 possibles tipus de desbalanceig
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

    public ArrayList getTo_export_posts() {
        return to_export_posts;
    }

    public void setTo_export_posts(ArrayList to_export_posts) {
        this.to_export_posts = to_export_posts;
    }

    public NodeAVL getRoot() {
        return root;
    }

    public void setRoot(NodeAVL root) {
        this.root = root;
    }
}
