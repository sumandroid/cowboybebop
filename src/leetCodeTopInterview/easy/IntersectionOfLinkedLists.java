package leetCodeTopInterview.easy;

public class IntersectionOfLinkedLists {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = 0;
            int lengthB = 0;
            ListNode curr = headA;
            while(curr != null){
                lengthA++;
            }
            curr = headB;
            while(curr != null){
                lengthB++;
            }
            ListNode tempA = headA;
            ListNode tempB = headB;
            if(lengthA > lengthB){
                int diff = lengthA - lengthB;
                while(diff >= 0){
                    tempA = tempA.next;
                    diff--;
                }
            }
            if(lengthB > lengthA){
                int diff = lengthB - lengthA;
                while(diff >= 0){
                    tempB = tempB.next;
                    diff--;
                }
            }
            while(tempA != null || tempB != null){
                if(tempA == tempB){
                    return tempA;
                }
                tempA = tempA.next;
                tempB = tempB.next;
            }
            return null;
        }
    }

    private static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val){
            this.next = null;
            this.val = val;
        }
    }
}
