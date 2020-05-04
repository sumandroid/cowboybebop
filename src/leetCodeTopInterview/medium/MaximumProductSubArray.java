package leetCodeTopInterview.medium;

public class MaximumProductSubArray {

    public static void main(String []args){
        int[] nums = new int[]{2,3,-2,4};
        int max = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = currentMax;
            currentMax = Math.max(Math.max(currentMax * nums[i], currentMin * nums[i]), nums[i]);
            currentMin = Math.min(Math.min(temp * nums[i], currentMin * nums[i]), nums[i]);
            max = Math.max(max, currentMax);
        }
        System.out.println(max);
    }
}
