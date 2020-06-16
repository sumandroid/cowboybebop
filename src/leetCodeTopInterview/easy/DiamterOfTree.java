package leetCodeTopInterview.easy;

public class DiamterOfTree {

    static int res = 0;

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        MeasureDiameter(root);
        System.out.println(res);
    }

    private static int MeasureDiameter(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = MeasureDiameter(root.left);
        int r = MeasureDiameter(root.right);
        res = Math.max(res, l+r);
        return Math.max(l, r) + 1;
    }


    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
}
