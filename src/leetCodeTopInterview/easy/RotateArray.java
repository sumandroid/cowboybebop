package leetCodeTopInterview.easy;

public class RotateArray {
    //problem: https://leetcode.com/problems/rotate-array/

    public static void main(String []args){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void rotate(int[] nums, int k){
        if(nums.length == 0){
            return;
        }
        k = k % nums.length; // the idea to take mod of k with nums.length is if k is multiple of nums.length the array remains unrotated
                            // and if it is greater then the length we are only interested in the difference between k and nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
