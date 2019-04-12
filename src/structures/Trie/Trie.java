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
                index = key.charAt(lvl) - 'a';
            else
                index = key.charAt(lvl);

            if(actual.getSons()[index] == null)
                actual.getSons()[index] = new TrieNode();

            actual = actual.getSons()[index];
        }   //for

        actual.setEndOfWord(true);      // Last Node as leaf
    }

    public boolean search(String key){
        int lvl, lenght = key.length(), index;

        boolean found = true;

        TrieNode actual = root;

        // Depth control of the word
        for(lvl = 0; lvl < lenght; lvl++){

            index = key.charAt(lvl) - 'a';
            if(actual.getSons()[index] == null)
                found = false;

            actual = actual.getSons()[index];
        }   //for

        if(!found)
            return found;
        else
            return actual != null && actual.isEndOfWord();
    }
}
