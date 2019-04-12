import JsonObjects.JsonInteraction;
import JsonObjects.Objects.User;
import structures.AVLTree.AVLTree;
import structures.HashTable.MapHash;
import structures.RedBlackTree.RedBlackTree;
import structures.Trie.Trie;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        final String PATH_TEST = "jsons/json_test.json";

        JsonInteraction jInteraction = new JsonInteraction();

        User[] users = jInteraction.deserializeJSON(PATH_TEST);

        AVLTree avlTree = new AVLTree();
        MapHash mapHash = new MapHash(users.length);
        Trie trie = new Trie();

        for (int i = 0; i < users.length; i++){
            avlTree.insert_T(users[i].getUsername().hashCode(), users[i]);
            mapHash.add(users[i].getUsername().hashCode(), users[i]);
            trie.insert(users[i].getUsername());
        }   //for

        System.out.println("END");
    }
}
