package leetCodeTopInterview.medium;

public class SortList {

    public static void main(String []args){
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next= new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode newHead = sortList(head);
        while(newHead != null){
            System.out.print(newHead.val);
            newHead = newHead.next;
        }
    }

    private static ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode slow = temp;
        ListNode fast = temp;
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;
        ListNode leftList = sortList(head);
        ListNode rightList = sortList(slow);
        return mergeLists(leftList, rightList);
    }

    private static ListNode mergeLists(ListNode l, ListNode r){
        ListNode sortedTemp = new ListNode(0);
        ListNode current = sortedTemp;
        while(l != null && r != null){
            if(l.val < r.val){
                current.next = l;
                l = l.next;
            }else{
                current.next = r;
                r= r.next;
            }
            current = current.next;
        }
        while(l != null){
            current.next = l;
            l = l.next;
        }
        while(r != null){
            current.next = r;
            r = r.next;
        }
        return sortedTemp.next;
    }

    private static class ListNode{
        private Integer val;
        private ListNode next;

        public ListNode(Integer value){
            this.val = value;
            this.next = null;
        }
    }
}
