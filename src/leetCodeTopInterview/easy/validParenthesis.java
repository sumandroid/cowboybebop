package leetCodeTopInterview.easy;

import java.util.Stack;

public class validParenthesis {

    //problem: https://leetcode.com/problems/valid-parentheses/

    public static void main(String []args){
        String input = "()[]{";
        System.out.println(isValid(input));
    }

    private static boolean isValid(String input){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(isOpenBracket(c)){
                stack.push(c);
            }else{
                Character topElement = stack.pop();
                if(c == ')' && topElement != '('){
                    return false;
                }else if(c == ']' && topElement != '['){
                    return false;
                }else if(c == '}' && topElement != '{'){
                    return false;
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    private static boolean isOpenBracket(Character c){
        if(c == '(' || c == '[' || c == '{'){
            return true;
        }
        return false;
    }
}
