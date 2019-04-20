import JsonObjects.JsonInteraction;
import JsonObjects.Objects.Post;
import JsonObjects.Objects.User;
import structures.AVLTree.AVLTree;
import structures.HashTable.MapHash;
import structures.Trie.Trie;

import static JsonObjects.Objects.TransferToMyArrayList.transferInfoToMyArraylist;


public class Test {
    public static void main(String[] args){
        final String PATH_TEST = "jsons/users.json";
        final String PATH_TEST2 = "jsons/posts.json";

        User aux = new User();
        User[] users = (User[]) aux.deserializeJSON(PATH_TEST);
        transferInfoToMyArraylist(users);

        Post aux2 = new Post();
        Post[] posts = (Post[]) aux2.deserializeJSON(PATH_TEST2);
        transferInfoToMyArraylist(posts);

        AVLTree avlTree = new AVLTree();
        MapHash mapHash = new MapHash(users.length);
        Trie trie = new Trie();

        for (int i = 0; i < users.length; i++){
            avlTree.insert_T(users[i].getUsername().hashCode(), users[i]);
            mapHash.add(users[i].getUsername().hashCode(), users[i]);
            trie.insert(users[i].getUsername());
        }   //for

        String name = "alexander.roca";
        User user = (User) mapHash.get(name.hashCode());

        mapHash.remove(name.hashCode());
        mapHash.remove(name.hashCode());

        System.out.println("END");
    }
}
