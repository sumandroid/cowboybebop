package leetCodeTopInterview.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidPalindrome {
    //problem: https://leetcode.com/problems/valid-palindrome/

    public static void main(String []args){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s){
        if(s == null || s.equals("")){
            return true;
        }
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('b');
        set.add('c');
        set.add('d');
        set.add('e');
        set.add('f');
        set.add('g');
        set.add('h');
        set.add('i');
        set.add('j');
        set.add('k');
        set.add('l');
        set.add('m');
        set.add('n');
        set.add('o');
        set.add('p');
        set.add('q');
        set.add('r');
        set.add('s');
        set.add('t');
        set.add('u');
        set.add('v');
        set.add('w');
        set.add('x');
        set.add('y');
        set.add('z');
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
        List<Character> l1 = new ArrayList<>();
        for(Character c : s.toLowerCase().toCharArray()){
            if(set.contains(c)){
                l1.add(c);
            }
        }
        List<Character> l2 = new ArrayList<>();
        char[] ca = s.toLowerCase().toCharArray();
        for(int i = ca.length - 1; i >= 0; i--){
            if(set.contains(ca[i])){
                l2.add(ca[i]);
            }
        }
        return l1.equals(l2);
    }
}
