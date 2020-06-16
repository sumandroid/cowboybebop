package leetCodeTopInterview.medium;

public class TotalNumberOfUniqueBST {

    public static void main(String []args){
        int n = 4;
        System.out.println("Number of total unique BST: " + findAllUniqueTrees(n));
    }

    private static int findAllUniqueTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = (dp[i] + dp[j-1] * dp[i-j]);
            }
        }
        return dp[n];
    }
}
