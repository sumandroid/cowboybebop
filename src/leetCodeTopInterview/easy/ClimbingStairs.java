package leetCodeTopInterview.easy;

public class ClimbingStairs {
    //problem: https://leetcode.com/problems/climbing-stairs/

    public static void main(String []args){
        int n = 4;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.print(dp[n]);
    }
}
