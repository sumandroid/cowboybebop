package miscallaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PreOrderFromBST {
    private static int[] preOrder = {10,5,1,7,40,50};

    public static void main(String []args){
        Node root = new Node(preOrder[0]);
        int i = 1;
        while(preOrder[i] < root.data){
            i++;
        }
        i--;
        List<Integer> leftSubTree = new ArrayList<>();
        List<Integer> rightSubTree = new ArrayList<>();
        for(int j = 1; j <= i; j++){
            leftSubTree.add(preOrder[j]);
        }
        for(int k = preOrder.length - i + 1; k < preOrder.length; k++){
            rightSubTree.add(preOrder[k]);
        }
        Collections.sort(leftSubTree);
        Collections.sort(rightSubTree);
        createBST(leftSubTree, rightSubTree, root);
    }

    static void createBST(List<Integer> leftSubTree, List<Integer> rightSubTree, Node root){
        if(!leftSubTree.isEmpty() && !rightSubTree.isEmpty()){
            Node temp = root;
            while(!leftSubTree.isEmpty()){
                Node newNode = new Node(leftSubTree.get(leftSubTree.size() - 1));
                temp.left = newNode;
                leftSubTree.remove(leftSubTree.size() - 1);
                temp = temp.left;
            }
            Node temp2 = root;
            while(!rightSubTree.isEmpty()){
                Node newNode = new Node(rightSubTree.get(0));
                temp2.right = newNode;
                rightSubTree.remove(0);
                temp2 = temp2.right;
            }
        }
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
}
