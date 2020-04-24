package com.company;

import org.omg.CORBA.UserException;

import java.util.*;

public class NodesAtDistanceK {
    private static Map<Node, Node> nodeToParentMap = new HashMap<>();
    private static int k = 2;
    private static Queue<Node> q = new LinkedList<>();
    private static int currentLevel = 0;
    private static Set<Node> seen = new HashSet<>();

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(7);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(1);
        root.right.right = new Node(8);
        root.left.left.left = new Node(9);
        root.left.left.right = new Node(10);
        prepareNodesToParentMap(nodeToParentMap, root, null);
        q.add(root.left);
        printAllNodesAtDistanceK();
    }


    static class Node {
        private int data;
        private Node left;
        private Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static void printAllNodesAtDistanceK() {
        while (!q.isEmpty()) {
            if(currentLevel == k){
                printQueue(q);
                return;
            }
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node currNode = q.poll();
                seen.add(currNode);
                if (currNode.left != null && !seen.contains(currNode.left)) {
                    seen.add(currNode.left);
                    q.add(currNode.left);
                }
                if (currNode.right != null && !seen.contains(currNode.right)) {
                    seen.add(currNode.right);
                    q.add(currNode.right);
                }
                Node parentNode = nodeToParentMap.get(currNode);
                if (parentNode != null && !seen.contains(parentNode)) {
                    seen.add(parentNode);
                    q.add(parentNode);
                }
            }
            currentLevel++;
        }
    }

    static void prepareNodesToParentMap(Map<Node, Node> nodeToParentMap, Node root, Node parent) {
        if (root == null) {
            return;
        }
        nodeToParentMap.put(root, parent);
        prepareNodesToParentMap(nodeToParentMap, root.left, root);
        prepareNodesToParentMap(nodeToParentMap, root.right, root);
    }

    static void printQueue(Queue<Node> q){
        while(!q.isEmpty()){
            System.out.print(q.poll().data + "\t");
        }
    }
}
