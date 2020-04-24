package com.company;

public class ConvertBinaryTreeToDLL {
    public static TreeNode root;
    public static DLL head;
    public static DLL tempHead;
    public static void main(String []args){
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        convertTreeToDll(root);
        printDLL();
    }

    private static void printDLL() {
        StringBuilder stringBuilder = new StringBuilder();
        DLL curr = tempHead;
        while(curr != null){
            stringBuilder.append(curr.val).append("<->");
            curr = curr.next;
        }
        stringBuilder.append("null");
        System.out.println(stringBuilder.toString());
    }

    public static void convertTreeToDll(TreeNode root){
        if(root == null){
            return;
        }
        convertTreeToDll(root.left);
        if(head == null){
            head = new DLL(root.val);
            tempHead = head;
        }else{
            DLL node = new DLL(root.val);
            head.next = node;
            node.prev = head;
            head = node;

        }
        convertTreeToDll(root.right);
    }


    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    private static class DLL{
        private int val;
        private DLL next;
        private DLL prev;

        public DLL(int val){
            this.val = val;
        }
    }
}
