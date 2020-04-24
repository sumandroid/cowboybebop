package leetCodeTopInterview.easy;

import java.util.Stack;

public class PalindromeLinkedList {

    //problem: https://leetcode.com/problems/palindrome-linked-list/

    public static void main(String []args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            stack.add(curr);
            curr = curr.next;
        }
        curr = head;
        while(!stack.isEmpty()){
            ListNode top = stack.pop();
            if(curr.val != top.val){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }


    private static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
}
