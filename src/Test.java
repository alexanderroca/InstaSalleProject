import JsonObjects.Objects.Post;
import JsonObjects.Objects.User;
import structures.AVLTree.AVLTree;
import structures.Graph.Graph;
import structures.HashTable.MapHash;
import structures.MyArrayList.MyArrayList;
import structures.RTree.RTree;
import structures.Trie.Trie;

import static JsonObjects.Objects.TransferToMyArrayList.transferInfoToMyArraylist;

/**
 * Classe per testejar
 * @author Alexander Roca
 * @version 0.1
 */

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

        Graph graph = new Graph(users, posts);
        AVLTree avlTree = new AVLTree();
        MapHash mapHash = new MapHash(users.length);
        Trie trie = new Trie();

        double[] coords = {-10000, -10000, 10000, 10000};
        RTree rtree = new RTree(4, coords);

        MyArrayList arrayList = new MyArrayList(1);

        arrayList.add(1);
        arrayList.add(2);

        for (int i = 0; i < users.length; i++){
            avlTree.insert_T(users[i].getUsername().hashCode(), users[i]);
            mapHash.add(users[i].getUsername().hashCode(), users[i]);
            trie.insert(users[i].getUsername());
        }   //for

        for(int i = 0; i < posts.length; i++) {
            double[] coords_aux = new double[2];

            coords_aux[0] = (double) posts[i].getLocation().get(0);
            coords_aux[1] = (double) posts[i].getLocation().get(1);

            rtree.insert_T(coords_aux, posts[i]);
        }   //for

        trie.insert("alexus");
        trie.insert("alexis");

        MyArrayList words = new MyArrayList(1);

        trie.suggerationsTrie("Pepito");
        MyArrayList possible_words = trie.getPossible_words();

        boolean test = graph.remove("marc.cespedes", 1);

        String name = "marc.cespedes";
        User user = (User) mapHash.get(name.hashCode());

        mapHash.remove(name.hashCode());
        mapHash.remove(name.hashCode());

        System.out.println("END");
    }
}
