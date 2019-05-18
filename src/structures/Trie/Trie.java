package structures.Trie;

import structures.MyArrayList.MyArrayList;

public class Trie {
    public static final int MAX_CHAR = 256;
    private TrieNode root;
    private MyArrayList possible_words;

    public Trie() {
        root = new TrieNode();
        possible_words = new MyArrayList(1);
    }

    public void insert(String key){
        int lvl, lenght = key.length(), index;

        TrieNode actual = root;

        // Depth control of the word
        for(lvl = 0; lvl < lenght; lvl++){
            if(key.charAt(lvl) >= 'A' && key.charAt(lvl) <= 'Z' )
                index = key.charAt(lvl) - 'A' + 'a';
            else
                index = key.charAt(lvl);

            if(actual.getSons()[index] == null)
                actual.getSons()[index] = new TrieNode();

            actual = actual.getSons()[index];
        }   //for

        actual.setEndOfWord(true);      // Last Node as leaf
    }

    public void suggerationsTrie(String prefix){

        int lvl, index;
        boolean found = true;

        TrieNode actual = root;

        for(lvl = 0; lvl < prefix.length(); lvl++){
            if(prefix.charAt(lvl) >= 'A' && prefix.charAt(lvl) <= 'Z' )
                index = prefix.charAt(lvl) - 'A' + 'a';
            else
                index = prefix.charAt(lvl);

            if(actual.getSons()[index] == null)
                found = false;

            actual = actual.getSons()[index];
        }   //for

        if(!found)
            System.out.println("No hi ha cap coincidencia amb aquest prefix");
        else{
            for(int i = 0; i < actual.getSons().length; i++){

                if(actual.getSons()[i] != null){
                    String word = prefix.concat(String.valueOf((char) i));
                    suggerationsTrie(word);
                }   //if
            }   //for
        }   //else

        if(actual.isEndOfWord()) {
            possible_words.add(prefix);
        }   //if
    }

    public boolean search(String key) throws NullPointerException{
        int lvl, lenght = key.length(), index;

        boolean found = true;

        TrieNode actual = root;

        // Depth control of the word
        for(lvl = 0; lvl < lenght; lvl++){

            if(key.charAt(lvl) >= 'A' && key.charAt(lvl) <= 'Z' )
                index = key.charAt(lvl) - 'A' + 'a';
            else
                index = key.charAt(lvl);

            if(actual.getSons()[index] == null)
                found = false;

            actual = actual.getSons()[index];
        }   //for

        if(!found)
            return found;
        else
            return actual != null && actual.isEndOfWord();
    }

    public void remove_T(String key){
        remove(root, key, 0);
    }

    public boolean remove(TrieNode n, String key, int index){

        if(index == key.length()) {
            if (!n.isEndOfWord())
                return false;
            n.setEndOfWord(false);
            return n.getSons().length == 0;
        }   //if

        char character = key.charAt(index);

        if (n.getSons()[key.charAt(index)] == null)
            return false;

        boolean shouldDeleteThisNode = remove(n.getSons()[key.charAt(index)], key, index + 1);

        if(shouldDeleteThisNode){
            n.getSons()[character] = null;
            return n.getSons().length == 0;
        }   //if

        return false;
    }

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }

    public MyArrayList getPossible_words() {
        return possible_words;
    }

    public void setPossible_words(MyArrayList possible_words) {
        this.possible_words = possible_words;
    }
}
