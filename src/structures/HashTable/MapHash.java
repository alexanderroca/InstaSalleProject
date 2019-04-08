package structures.HashTable;
import java.util.ArrayList;

public class MapHash<K,V> {
    private ArrayList<NodeHash<K,V>> array;
    private int capacity;
    private int size;

    //Constructor, need a dimension for HashTable
    public MapHash(int dimension){
        array = new ArrayList<>();
        capacity = dimension;
        size = 0;
        for(int i = 0; i < capacity; i++)
            array.add(null);
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
        return key.hashCode() % capacity;
    }

    //Get NodeAVL of MapHash
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

    //Add Value on MapHash
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
}
