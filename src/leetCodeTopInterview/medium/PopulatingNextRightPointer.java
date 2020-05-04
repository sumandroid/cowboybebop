package leetCodeTopInterview.medium;

public class PopulatingNextRightPointer {

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        util(root);
    }

    private static void util(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }
        util(root.left);
        util(root.right);
    }


    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode next;

        public TreeNode(int val){
            this.val = val;
        }
    }
}
