package leetCodeTopInterview.medium;

import leetCodeTopInterview.easy.TreeNode;

import java.util.*;

class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> res = new ArrayList<>();
    public Queue<TreeNode> queue = new LinkedList<>();
    public boolean goingLeft = true;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        queue.add(root);
        res.add(Arrays.asList(root.val));
        inOrderZigZagTraverse(root);
        return res;
    }

    public void inOrderZigZagTraverse(TreeNode root) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    tempList.add(node.left.val);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    tempList.add(node.right.val);
                    queue.add(node.right);
                }
            }
            if (tempList.size() > 0) {
                if (goingLeft) {
                    Collections.reverse(tempList);
                }
                res.add(tempList);
            }
            goingLeft = !goingLeft;
        }
    }

    private class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }
}