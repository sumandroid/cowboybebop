package leetCodeTopInterview.medium;

public class ValidateBinarySearchTree {

        public static void main(String []args){
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(1);
            root.right = new TreeNode(6);
            root.right.left = new TreeNode(3);
            root.right.right = new TreeNode(6);
            System.out.println(isValid(root, null, null));
        }

        public static boolean isValid(TreeNode root, TreeNode lower, TreeNode upper){
            if(root == null){
                return true;
            }
            if(lower != null && lower.val > root.val){
                return false;
            }
            if(upper != null && upper.val < root.val){
                return false;
            }
            return isValid(root.left, lower, root) && isValid(root.right, root, upper);
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
