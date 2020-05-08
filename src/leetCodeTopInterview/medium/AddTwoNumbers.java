package leetCodeTopInterview.medium;

import java.util.LinkedList;
import java.util.Queue;

public class AddTwoNumbers {

    public static void main(String []args){
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);
        addTwoNumber(head1, head2);
    }

    private static void addTwoNumber(Node head1, Node head2){
        Node curr1 = head1;
        Node curr2 = head2;
        Queue<Integer> queue = new LinkedList<>();
        int carry = 0;
        int sum = 0;
        while(curr1 != null || curr2 != null){
            int firstNumber = 0;
            int secondNumber = 0;
            if(curr1 != null){
                firstNumber = curr1.val;
                curr1 = curr1.next;
            }
            if(curr2 != null){
                secondNumber = curr2.val;
                curr2 = curr2.next;
            }
            int tempSum = firstNumber + secondNumber + carry;
            if(tempSum >= 10){
                sum = tempSum % 10;
                carry = tempSum / 10;
            }else{
                sum = tempSum;
                carry = 0;
            }
            queue.add(sum);
        }

        if(carry > 0){
            queue.add(carry);
        }

        Node tempHead = new Node(queue.poll());
        Node curr3 = tempHead;
        while(!queue.isEmpty()){
            curr3.next = new Node(queue.poll());
            curr3 = curr3.next;
        }

        while(tempHead != null){
            System.out.print(tempHead.val + " ");
            tempHead = tempHead.next;
        }
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
