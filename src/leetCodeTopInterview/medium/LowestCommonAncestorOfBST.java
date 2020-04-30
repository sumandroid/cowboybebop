package leetCodeTopInterview.medium;

public class LowestCommonAncestorOfBST {
    static  TreeNode ancestor =  null;
    public static void main(String []args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        lca(root, root.left, root.right);
        System.out.println(ancestor.val);

    }

    private static boolean lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        int left = lca(root.left, p, q) ? 1 : 0;
        int right = lca(root.right, p, q)? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(right+left+mid >= 2){
            ancestor = root;
        }
        return right + left + mid > 0;
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
