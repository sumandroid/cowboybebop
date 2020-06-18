package miscallaneous;


import java.util.Arrays;

//given a knapsack of capacity C and N items with weight wi and value vi, choose the maximum valued combination which can be fit into the bag
public class KnapsackProblem {

    public static void main(String []args){
        int[] val = {10, 20, 30};
        int[] wt = {1,1,1};
        int capacity = 2;
        int[][] dp = new int[wt.length][val.length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(knapsack(capacity, wt, val, val.length));
        System.out.println(knapsackMemoised(capacity, wt, val, val.length - 1, dp));
    }

    //without memoisation
    private static int knapsack(int capacity, int[] wt, int[] val, int n){
        if(capacity == 0 || n == 0){
            return 0;
        }

        if(wt[n-1] > capacity){
            return knapsack(capacity, wt, val, n-1);
        }else{
            return Math.max(knapsack(capacity - wt[n-1], wt, val, n-1) + val[n-1], knapsack(capacity, wt, val, n-1));
        }
    }

    //with memoisation
    private static int knapsackMemoised(int capacity, int[] wt, int[] val, int i, int[][] dp){
        if(capacity == 0 || i < 0){
            return 0;
        }
        if(dp[capacity][i] != -1){
            return dp[capacity][i];
        }else{
            if(wt[i] > capacity){
                dp[capacity][i] = knapsackMemoised(capacity, wt, val, i - 1, dp);
                return dp[capacity][i];
            }else{
                dp[capacity][i] = Math.max(knapsackMemoised(capacity - wt[i], wt, val, i-1, dp) + val[i], knapsackMemoised(capacity - wt[i], wt, val, i-1, dp));
                return dp[capacity][i];
            }
        }
    }
}
