package leetCodeTopInterview.easy;

public class ReverseLinkedList {

    public static void main(String []args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode prev = reverse(head, null);
        while(prev != null){
            System.out.print(prev.val);
            prev = prev.next;
        }
    }

    public static ListNode reverse(ListNode head, ListNode prev){
        if(head == null){
            return prev;
        }
        ListNode temp = head.next;
        head.next = prev;
        prev = head;
        return reverse(temp, prev);
    }


    private static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
}
