package leetCodeTopInterview.medium;

public class UniquePaths {
    public static void main(String []args){
        int m = 7;
        int n = 3;
        int[][] dp = new int[m][3];
        dp[0][0] = 0;
        for(int i = 1; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println(dp[m-1][n-1]);
    }
}
