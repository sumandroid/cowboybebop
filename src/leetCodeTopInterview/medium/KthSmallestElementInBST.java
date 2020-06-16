package leetCodeTopInterview.medium;

public class KthSmallestElementInBST {

    public static void main(String []args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        kthSmallestElement(root, 2);
    }

    private static void kthSmallestElement(TreeNode root, int k){
        TreeNode tempNode = root;
        heapify(tempNode);
    }

    private static void heapify(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode largest = root;
        if(root.left != null && root.left.val > root.val){
            largest = root.left;
        }
        if(root.right != null && root.right.val > root.val){
            largest = root.right;
        }
        if(largest != root){
            swap(root, largest);
        }
        heapify(root.left);
        heapify(root.right);
    }

    private static void swap(TreeNode n1, TreeNode n2){
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
