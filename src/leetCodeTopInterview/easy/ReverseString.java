package leetCodeTopInterview.easy;

public class ReverseString {

    //problem : https://leetcode.com/problems/reverse-string/

    public static void main(String []args){
        String[] input = new String[]{"H","a","n","n","a","h"};
        reverse(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++){
            System.out.print(input[i] + " ");
        }
    }

    public static void reverse(String[] input, int start, int end){
        if(start < end){
            String temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
            reverse(input, start, end);
        }
    }

}
