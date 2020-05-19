package miscallaneous;

import java.util.HashMap;

/*

Given a list of contacts which exist in a phone directory. The task is to implement search query for the phone directory.
The search query on a string ‘str’ displays all the contacts which prefix as ‘str’.
One special property of the search function is that, when a user searches for a contact from the contact list then
 suggestions (Contacts with prefix as the string entered so for) are shown after user enters each character.
 */
public class PhoneDirectory {

    public static void main(String []args){
        String[] contacts = new String[]{"sumansaurabh", "sandeepkumar"};
        Trie trie = new Trie();
        trie.insert(contacts);
        trie.search("san");
    }

    private static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String[] words){
            for(String word : words) {
                TrieNode current = root;
                for(int i = 0; i < word.length(); i++){
                    TrieNode nextNode = current.getChildrens().get(word.charAt(i));
                    if(nextNode == null){
                        nextNode = new TrieNode();
                        current.childrens.put(word.charAt(i), nextNode);
                    }
                    current = nextNode;
                }
                current.setEndOfWord();
            }
        }

        public void search(String prefix){
            TrieNode current = root;
            for(int i = 0; i < prefix.length(); i++){
                current = current.getChildrens().get(prefix.charAt(i));
                if(current == null){
                    System.out.println("No suggestion found starting with prefix: " + prefix);
                    return;
                }
                else if(current.isEndOfWord()){
                    System.out.println("suggestion found starting with prefix: " + prefix.substring(0, i+1));
                    return;
                }
            }
            dfs(current, prefix);
        }

        private void dfs(TrieNode node, String prefix){
            if(node.isEndOfWord()){
                System.out.println(prefix);
                return;
            }
            for(char i = 'a'; i <= 'z'; i++){
                TrieNode nodeCurr = node.childrens.get(i);
                if(nodeCurr != null){
                    dfs(nodeCurr, prefix + i);
                }
            }
        }
    }

    private static class TrieNode{
        private HashMap<Character, TrieNode> childrens = new HashMap<>();
        private boolean isEndOfWord;

        public boolean isEndOfWord(){
            return isEndOfWord;
        }

        public void setEndOfWord(){
            isEndOfWord = true;
        }

        public HashMap<Character, TrieNode> getChildrens(){
            return childrens;
        }
    }
}
