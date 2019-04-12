import JsonObjects.JsonInteraction;
import JsonObjects.Objects.User;
import structures.AVLTree.AVLTree;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        final String PATH_TEST = "jsons/json_test.json";

        JsonInteraction jInteraction = new JsonInteraction();

        User[] users = jInteraction.deserializeJSON(PATH_TEST);

        AVLTree avlTree = new AVLTree();

        for (int i = 0; i < users.length; i++){
            avlTree.insert_T(users[i].getUsername().hashCode(), users[i]);
        }   //for

        System.out.println("END");
    }
}
