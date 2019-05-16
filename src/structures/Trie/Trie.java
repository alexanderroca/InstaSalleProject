package structures.Trie;

public class Trie {
    public static final int MAX_CHAR = 256;
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
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

}
