package leetCodeTopInterview.medium;

import java.util.HashMap;

public class CopyListWithRandomPointer {

    //no driver code too much of work :p Have a look at algo and you will be good to go.
    public Node copyList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> cloneMap = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.data);
            cloneMap.put(curr, clone);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if(curr.next != null){
                cloneMap.get(curr).next = cloneMap.get(curr.next);
            }
            if(curr.random != null){
                cloneMap.get(curr).random = cloneMap.get(curr.random);
            }
            curr = curr.next;
        }
        return cloneMap.get(head);
    }


    private class Node {
        private int data;
        private Node next;
        private Node random;

        public Node(int data) {
            this.data = data;
        }
    }
}
