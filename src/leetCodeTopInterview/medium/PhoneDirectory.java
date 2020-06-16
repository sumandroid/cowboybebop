package leetCodeTopInterview.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneDirectory {

    public static void main(String []args){
        List<String> contacts = Arrays.asList("sumansaurabh", "sandeepkumar");
        Trie trie = new Trie();
        trie.insert(contacts);
        String prefix = "su";
        trie.search(prefix);
    }

    private static class Trie{
        private TrieNode root;

        public Trie(){
            this.root = new TrieNode();
        }

        public void insert(List<String> contacts){
            contacts.forEach(contact -> {
                TrieNode current = root;
                for(int i = 0; i < contact.length(); i++){
                    TrieNode nextNode = current.getChildren().get(contact.charAt(i));
                    if(nextNode == null){
                        nextNode = new TrieNode();
                        current.getChildren().put(contact.charAt(i), nextNode);
                    }
                    current = nextNode;
                }
                current.setEndOfWord(true);
            });
        }

        public void search(String prefix){
            TrieNode current = root;
            for(int i = 0; i < prefix.length(); i++){
                current = current.getChildren().get(prefix.charAt(i));
                if(current == null){
                    System.out.println("no suggestions found for: " + prefix);
                    return;
                }else if(current.isEndOfWord()){
                    System.out.println("suggestions found starting with prefix: " + prefix.substring(0, i+1));
                    return;
                }

            }

            dfs(current, prefix);
        }

        private void dfs(TrieNode current, String prefix){
            if(current.isEndOfWord()){
                System.out.println("Suggestions found: " + prefix);
            }else{
                for(char c = 'a'; c <= 'z'; c++){
                    TrieNode node = current.getChildren().get(c);
                    if(node != null){
                        dfs(node, prefix+c);
                    }
                }
            }
        }

    }

    private static class TrieNode{
        private boolean endOfWord;
        private HashMap<Character, TrieNode> children = new HashMap<>();

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(HashMap<Character, TrieNode> children) {
            this.children = children;
        }
    }
}
