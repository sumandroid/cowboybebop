package leetCodeTopInterview.medium;

import java.util.Scanner;

public class LongestPalindromicSubsequence {

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("longest palindromic sequence: " + palindrome(s));
    }

    public static String palindrome(String s){
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCentre(s, i, i);
            int len2 = expandAroundCentre(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCentre(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }
}
