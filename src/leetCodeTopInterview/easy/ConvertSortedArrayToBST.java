package leetCodeTopInterview.easy;

public class ConvertSortedArrayToBST {
    //problem: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public static void main(String []args){
        int[] sortedArr = new int[]{-10,-3,0,5,9};
        TreeNode root = convertArrToBst(sortedArr, 0, sortedArr.length - 1);
        System.out.print(root.val);
    }

    private static TreeNode convertArrToBst(int[] nums, int start, int end){
        if(nums.length == 0){
            return null;
        }
        if(start > end){
            return null;
        }
        int mid = (start+end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convertArrToBst(nums, start, mid - 1);
        root.right = convertArrToBst(nums, mid + 1, nums.length - 1);
        return root;
    }

    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
}
