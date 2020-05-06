package leetCodeTopInterview.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithOutRepeatingCharacters {

    public static void main(String []args){
        String s = "abcabcbb";
        Set<Character> visited = new HashSet<>();

        int l = 0;
        int r = 0;
        int res = 0;
        while(r < s.length()){
            if(!visited.contains(s.charAt(r))){
                visited.add(s.charAt(r));
                res = Math.max(l-r, res);
                r++;
            }else{
                visited.remove(s.charAt(l));
                l++;
            }
        }
        System.out.println("res = " + res);
    }
}
