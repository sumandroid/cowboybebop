package leetCodeTopInterview.medium;

public class ConstructTreeFromInOrderAndPreOrder {

    public static int preIndex = 0;

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        constructBinaryTree(preorder, inorder, 0, inorder.length - 1);
    }


    private static TreeNode constructBinaryTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode tNode = new TreeNode(preorder[preIndex++]);
        if (start == end) {
            return tNode;
        }
        int inIndex = search(inorder, start, end, tNode.val);
        tNode.left = constructBinaryTree(preorder, inorder, start, inIndex - 1);
        tNode.right = constructBinaryTree(preorder, inorder, inIndex + 1, end);
        return tNode;
    }


    private static int search(int[] inOrder, int start, int end, int data) {
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == data) {
                return i;
            }
        }
        return -1;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
