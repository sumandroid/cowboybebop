package leetCodeTopInterview.medium;

public class OddEvenLinkedList {

    public static void main(String []args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        groupOddEven(head);
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val);
            curr = curr.next;
        }
    }

    private static void groupOddEven(Node head){
        if(head == null || head.next == null){
            return;
        }
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
    }


    private static class Node{
        private int val;
        private Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }
}
