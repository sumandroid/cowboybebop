package leetCodeTopInterview.easy;

public class SingleNumber {

    //problem: https://leetcode.com/problems/single-number/

    public static void main(String []args){
        int[] arr = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }

    private static int singleNumber(int[] arr){
        if(arr.length == 1){
            return arr[0];
        }
        int xor = arr[0];
        for(int i = 1; i < arr.length; i++){
            xor ^= arr[i];
        }
        return xor;
    }
}
