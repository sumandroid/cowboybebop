package leetCodeTopInterview.easy;

import java.util.HashMap;

public class TwoSum {
    //problem: https://leetcode.com/problems/two-sum/

    public static void main(String []args){
        int[] arr = new int[]{2, 7, 11, 15};
        int sum = 9;
        int[] res = twoSum(arr, sum);
        System.out.println(res[0] + "," + res[1]);
    }

    private static int[] twoSum(int[] arr, int sum){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int compliment = sum - arr[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            }else{
                map.put(arr[i], i);
            }
        }
        throw new IllegalArgumentException("no solution");
    }
}
