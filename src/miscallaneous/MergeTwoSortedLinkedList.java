package miscallaneous;

public class MergeTwoSortedLinkedList {
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public static class Solution {
          public static void main(String []args){
              ListNode l1 = new ListNode(1);
              l1.next = new ListNode(2);
              l1.next.next = new ListNode(4);
              ListNode l2 = new ListNode(1);
              l2.next = new ListNode(3);
              l2.next.next = new ListNode(4);
              mergeTwoLists(l1, l2);
          }
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null && l2 != null){
                return l2;
            }else if (l2 == null && l1 != null){
                return l1;
            }
            ListNode curr1 = l1;
            ListNode curr2 = l2;
            ListNode newList = new ListNode(0);
            ListNode temp = newList;
            while(curr1 != null || curr2 != null){
                while(curr1 != null && curr1.val < curr2.val){
                    temp.next = new ListNode(curr1.val);
                    curr1 = curr1.next;
                }
                while(curr2 != null && curr2.val < curr1.val){
                    temp.next = new ListNode(curr2.val);
                    curr2 = curr2.next;
                }
                if(curr2 != null && curr1 != null && curr1.val == curr2.val){
                    temp.next = new ListNode(curr2.val);
                    temp.next.next = new ListNode(curr1.val);
                    curr1 = curr1.next;
                    curr2 = curr2.next;
                    temp = temp.next;
                    temp = temp.next;
                }
            }
            return newList.next;
        }
    }
}
