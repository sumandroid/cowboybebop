package leetCodeTopInterview.easy;

public class MergeTwoSortedLinkedList {
    //problem: https://leetcode.com/problems/merge-two-sorted-lists/

    public static void main(String []args){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode newHead = new ListNode(-1);
        mergeLists(newHead, head1, head2);
        ListNode curr = newHead.next;
        while(curr!= null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }


    }

    private static void mergeLists(ListNode newHead, ListNode head1, ListNode head2){
        if(head1 == null && head2 == null){
            return;
        }
        if(head1 != null && head2 != null){
            if(head1.val < head2.val){
                newHead.next = new ListNode(head1.val);
                head1 = head1.next;
            }else{
                newHead.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            newHead = newHead.next;
            mergeLists(newHead, head1, head2);
        }
        else if(head1 != null && head2 == null){
            newHead.next = new ListNode(head1.val);
            newHead = newHead.next;
            mergeLists(newHead, head1.next, null);
        }
        else if(head1 == null && head2 != null){
            newHead.next = new ListNode(head2.val);
            newHead = newHead.next;
            mergeLists(newHead, null, head2.next);
        }
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
