package leetCodeTopInterview.hard;

public class MergeKSortedLists {
    // merging k sorted list without extra space.

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode l1 = lists[0];
        for(int i = 1; i < lists.length; i++){
            ListNode l2 = lists[i];
            l1 = merge(l1, l2);
        }
        return l1;
    }

    private static ListNode merge(ListNode l1, ListNode l2){
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while(l1 != null){
            temp.next = new ListNode(l1.val);
            temp = temp.next;
            l1 = l1.next;
        }
        while(l2 != null){
            temp.next = new ListNode(l2.val);
            temp = temp.next;
            l2 = l2.next;
        }
        return head.next;
    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
