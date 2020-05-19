package miscallaneous;

import java.util.HashMap;

class Trie {

    /** Initialize your data structure here. */
    private Node root;
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = root;
        for(int i = 0; i < word.length(); i++){
            current = current.getChildrens().computeIfAbsent(word.charAt(i), c -> new Node());
        }
        current.setIsEndOfWord();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node current = root;
        for(int i = 0; i < word.length(); i++){
            current = current.getChildrens().get(word.charAt(i));
            if(current == null){
                return false;
            }
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node current = root;
        for(int i = 0; i < prefix.length(); i++){
            current = current.getChildrens().get(prefix.charAt(i));
            if(current == null){
                return false;
            }
        }
        return true;
    }

    private class Node{
        private HashMap<Character, Node> childrens = new HashMap<>();
        boolean endOfWord;

        public HashMap<Character, Node> getChildrens(){
            return this.childrens;
        }

        public boolean isEndOfWord(){
            return this.endOfWord;
        }

        public void setIsEndOfWord(){
            this.endOfWord = true;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
