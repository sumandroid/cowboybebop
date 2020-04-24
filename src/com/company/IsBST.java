package com.company;

import java.util.ArrayList;
import java.util.List;

public class IsBST {
    static List<Integer> inOrderList = new ArrayList<>();
    public static void main(String []args){
        BST tree = new BST(6);
        tree.root.left = new Node(2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);
        inOrderTraversal(tree.root);
        for(Integer i : inOrderList){
            System.out.print(i + "\t");
        }
        boolean isBst = true;
        for(int i = 0; i < inOrderList.size() - 1; i++){
            if(inOrderList.get(i) > inOrderList.get(i + 1)){
                isBst = false;
            }
        }
        if(isBst){
            System.out.println("it is BST");
        }else{
            System.out.println("it is not BST");
        }
    }


    static class Node{
        private int data;
        private Node left;
        private Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class BST{
        private Node root;

        BST(int data){
            this.root = new Node(data);
        }
    }

    static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        inOrderList.add(root.data);
        inOrderTraversal(root.right);
    }
}
