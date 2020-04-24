package com.company;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithSum {

    public static void main(String []args){
        int[] arr = {10,2,-2,-20,10};
        int sum = -10;
        int res = findSubArraysWithSum(arr, sum);
        System.out.println("No. of subarrays: " + res);
    }

    static int findSubArraysWithSum(int[] arr, int sum){
        int currSum = 0;
        int res = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            currSum += arr[i];
            if(currSum == sum){
                res++;
            }
            if(sumMap.containsKey(currSum - sum)){
                res += sumMap.get(currSum - sum);
            }
            Integer count = sumMap.get(currSum);
            if(count == null){
                sumMap.put(currSum, 1);
            }else{
                sumMap.put(currSum, count + 1);
            }
        }
        return res;
    }
}
