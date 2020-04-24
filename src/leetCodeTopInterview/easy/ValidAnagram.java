package leetCodeTopInterview.easy;

import java.util.Arrays;

public class ValidAnagram {
    //problem: https://leetcode.com/problems/valid-anagram/

    public static void main(String []args){
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(isAnagram(s1, s2));
    }

    private static boolean isAnagram(String s1, String s2){
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return String.valueOf(charArray1).equals(String.valueOf(charArray2));
    }
}
