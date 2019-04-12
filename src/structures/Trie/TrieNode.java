package structures.Trie;

public class TrieNode {
    private boolean isEndOfWord;
    private TrieNode[] sons;

    public TrieNode(){
        sons = new TrieNode[Trie.MAX_CHAR];
        isEndOfWord = false;
        for(int i = 0; i < Trie.MAX_CHAR; i++)
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
