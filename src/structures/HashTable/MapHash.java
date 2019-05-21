package structures.HashTable;
import JsonObjects.Objects.Post;
import JsonObjects.Objects.User;
import structures.MyArrayList.MyArrayList;

import java.util.ArrayList;

/**
 * Classe de l'estructura HashTable
 * @param <K> : element que actua com identificador unic
 * @param <V> : element que sera emmagatzemat
 * @author Alexander Roca
 * @version 0.1
 */

public class MapHash<K,V> {
    private MyArrayList<NodeHash<K,V>> array;
    private int capacity;
    private int size;

    //Constructor, need a dimension for HashTable

    /**
     * Constructor per dimensionar la taula de Hash
     * @param dimension : int
     */
    public MapHash(int dimension){
        array = new MyArrayList<>(dimension);
        capacity = dimension;
        size = 0;
        for(int i = 0; i < capacity; i++) {
            array.add(null);
        }   //for
    }

    //Size of MapHash
    public int size() {
        return size;
    }

    //Check if MapHash is empty
    public boolean isEmpty(){
        return size() == 0;
    }

    //Get position of the key in the MapHash
    public int getNode(K key){
        return Math.abs(key.hashCode() % capacity);
    }

    public MyArrayList<V> get(String hashtag) {
        MyArrayList<V> posts = new MyArrayList<>(1);

        for (int i = 0; i < array.getSize(); i++) {

            try {
                NodeHash aux = array.get(i);
                while (aux != null) {
                    if (aux.getValue() instanceof Post) {

                        for(int j = 0; j < ((Post) aux.getValue()).getHashtags().size(); j++){
                            if(((Post) aux.getValue()).getHashtags().get(j).equals(hashtag))
                                System.out.println(((Post) aux.getValue()).getId() + " " + ((Post) aux.getValue()).getPublished_by());
                        }   //for
                        aux = aux.getNext();
                    }   //if
                }   //while
            } catch (NullPointerException e) {
            }
        }   //for

        return posts;
    }

    /**
     * Funcio per realitzar la cerca per la taula de Hash
     * @param key : K
     * @return V
     */
    public V get(K key){
        int index = getNode(key);
        NodeHash<K,V> node = array.get(index);

        while(node != null){

            if(node.getKey().equals(key))
                return node.getValue();

            node = node.getNext();
        }   //while

        return null;
    }

    /**
     * Procediment per inserir elements a la taula de Hash
     * @param key : K
     * @param value : V
     */
    public void add(K key, V value){
        int index = getNode(key);
        NodeHash<K,V> pos = array.get(index);

        boolean exists = false;

        while(pos != null && !exists){

            if(pos.getKey().equals(key)){
                pos.setValue(value);
                exists = true;
            }   //if

            pos = pos.getNext();
        }   //while

        if(!exists){
            size++;
            pos = array.get(index);
            NodeHash<K,V> new_node = new NodeHash<>(key, value);
            new_node.setNext(pos);
            array.set(index, new_node);
        }   //if
    }

    /**
     * Funcio que realitza la eliminacio d'un element que indiqui l'usuari
     * @param key : K
     * @return boolean
     */
    public boolean remove(K key){
        int index = getNode(key);
        boolean found = false;
        NodeHash<K,V> node = array.get(index);
        NodeHash<K,V> prev_node = null;

        while(node != null && !found){
            if(node.getKey().equals(key))
                found = true;
            else {
                prev_node = node;
                node = node.getNext();
            }   //else
        }   //while

        if(node == null)
            return false;

        size--;

        if(prev_node != null)
            prev_node.setNext(node.getNext());
        else
            array.set(index, node.getNext());

        return true;
    }

    /**
     * Procediment per mostrar tots els elements de tipus User de l'estructura
     */
    public void displayUsers(){
        for(int i = 0; i < array.getSize(); i++){

            try {
                NodeHash aux = array.get(i);
                while (aux != null) {
                    if(aux.getValue() instanceof User) {
                        System.out.println(((User) aux.getValue()).getUsername());
                        aux = aux.getNext();
                    }   //if
                }   //while
            } catch(NullPointerException e){}
        }   //for
    }

    /**
     * Procediment per mostrar tots els elements de tipus Post de l'estructura
     */
    public ArrayList displayPosts(){
        ArrayList export = new ArrayList();

        for(int i = 0; i < array.getSize(); i++){

            try {
                NodeHash aux = array.get(i);
                while (aux != null) {
                    if(aux.getValue() instanceof Post) {
                        System.out.println(((Post) aux.getValue()).getId() + " Hashtags: ");
                        for(int j = 0; j < ((Post) aux.getValue()).getHashtags().size(); j++)
                            System.out.print(((Post) aux.getValue()).getHashtags().get(j) + " ");
                        export.add(aux.getValue());
                        aux = aux.getNext();
                    }   //if
                }   //while
            } catch(NullPointerException e){}
        }   //for

        return export;
    }
}
