package leetCodeTopInterview.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LeftMostViewOfTree {

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        printLeftView(root);
    }

    private static void printLeftView(TreeNode root){
        int maxDepth = -1;
        HashMap<Integer, Integer> leftMostValueAtDepth = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        queue.add(root);
        depthQueue.add(0);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int depth = depthQueue.poll();
            if(node != null){
                maxDepth = Math.max(depth, maxDepth);

                leftMostValueAtDepth.put(depth, node.val);
                queue.add(node.right);
                queue.add(node.left);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }

        for(int i = 0; i <= maxDepth; i++){
            System.out.print(leftMostValueAtDepth.get(i) + " ");
        }
    }


    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
