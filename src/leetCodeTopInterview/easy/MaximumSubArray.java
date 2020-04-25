package leetCodeTopInterview.easy;

public class MaximumSubArray {

    //problem: https://leetcode.com/problems/maximum-subarray/

    public static void main(String []args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxLength = maxSubArray(nums);
        System.out.print(maxLength);
    }

    //implementing kadane's algo
    private static int maxSubArray(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int maxEndingHere = 0;
        int maxEndingSoFar = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            maxEndingHere += nums[i];
            maxEndingSoFar = Math.max(maxEndingSoFar, maxEndingHere);
            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }

        }
        return maxEndingSoFar;
    }
}
