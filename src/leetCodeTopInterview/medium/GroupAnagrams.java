package leetCodeTopInterview.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String []args){
        String[] words = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(words);
        for(List<String> l : res){
            for(String s : l){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static List<List<String>> groupAnagrams(String[] words){
        if(words == null || words.length == 0){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        return new ArrayList(map.values());
    }
}
