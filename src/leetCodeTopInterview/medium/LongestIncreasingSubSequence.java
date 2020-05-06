package leetCodeTopInterview.medium;

public class LongestIncreasingSubSequence {
    public static void main(String []args){
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int res = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            int maxValue = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    maxValue = Math.max(maxValue, dp[j]);
                }
            }
            dp[i] = maxValue + 1;
            res = Math.max(res, dp[i]);
        }
        System.out.println("res = " + res);
    }
}
