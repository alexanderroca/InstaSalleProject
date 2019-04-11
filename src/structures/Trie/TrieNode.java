package structures.Trie;

public class TrieNode {
    private boolean isEndOfWord;
    private TrieNode[] sons;

    public TrieNode(){
        sons = new TrieNode[Trie.ALPHABET];
        isEndOfWord = false;
        for(int i = 0; i < Trie.ALPHABET; i++)
            sons[i] = null;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.isEndOfWord = endOfWord;
    }

    public TrieNode[] getSons() {
        return sons;
    }

    public void setSons(TrieNode[] sons) {
        this.sons = sons;
    }
}
