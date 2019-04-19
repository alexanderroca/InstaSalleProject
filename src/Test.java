import JsonObjects.JsonInteraction;
import JsonObjects.Objects.Post;
import JsonObjects.Objects.User;
import structures.AVLTree.AVLTree;
import structures.HashTable.MapHash;
import structures.Trie.Trie;


public class Test {
    public static void main(String[] args){
        final String PATH_TEST = "jsons/users.json";
        final String PATH_TEST2 = "jsons/posts.json";

        User aux = new User();
        User[] users = (User[]) aux.deserializeJSON(PATH_TEST);

        Post aux2 = new Post();
        Post[] posts = (Post[]) aux2.deserializeJSON(PATH_TEST2);

        AVLTree avlTree = new AVLTree();
        MapHash mapHash = new MapHash(users.length);
        Trie trie = new Trie();

        for (int i = 0; i < users.length; i++){
            avlTree.insert_T(users[i].getUsername().hashCode(), users[i]);
            mapHash.add(users[i].getUsername().hashCode(), users[i]);
            trie.insert(users[i].getUsername());
        }   //for

        boolean test = trie.search("alexander.roca");
        trie.remove_T("alexander.roca");
        test = trie.search("alexander.roca");
        String username = "alexander.roca";
        avlTree.remove_T(username.hashCode());

        System.out.println("END");
    }
}
