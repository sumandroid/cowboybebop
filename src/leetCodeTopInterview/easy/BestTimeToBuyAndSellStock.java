package leetCodeTopInterview.easy;

public class BestTimeToBuyAndSellStock {

    //problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    public static void main(String []args){
        int[] prices = new int[]{7,6,4,3,1};
        int profit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        System.out.print(profit);
    }
}
