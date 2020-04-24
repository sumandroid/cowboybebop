package leetCodeTopInterview.easy;

public class MissingNumber {
    //problem: https://leetcode.com/problems/missing-number/submissions/
    public static void main(String []args){
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
        int missing = nums.length;
        for(int i = 0; i < nums.length; i++){
            missing ^= i ^ nums[i];
        }
        System.out.print(missing);
    }
}
