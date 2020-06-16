package leetCodeTopInterview.easy;

public class PathSum {

    public boolean hasPath(TreeNode root, int sum){
        return util(root, sum);
    }

    private boolean util(TreeNode root, int sum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        return util(root.left, sum - root.val) || util(root.right, sum - root.val);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
