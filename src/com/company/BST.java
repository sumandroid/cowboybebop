package com.company;

import java.util.ArrayList;
import java.util.List;

public class BST {

    static Node head;

    public static void main(String []args){
        List<Integer> res = new ArrayList<>();
        res.add(1);
        BST tree = new BST();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        head = tree.arrayToBst(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(head);
    }

    Node arrayToBst(int[] a, int start, int end){ // creates BST using sorted array
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(a[mid]);
        node.left = arrayToBst(a, start, mid - 1);
        node.right = arrayToBst(a, mid + 1, end);
        return node;
    }


    class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    void preOrder(Node head){
        if (head == null){
            return;
        }
        System.out.print(head.data + " ");
        preOrder(head.left);
        preOrder(head.right);
    }
}
