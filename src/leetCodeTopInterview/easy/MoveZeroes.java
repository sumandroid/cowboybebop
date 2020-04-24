package leetCodeTopInterview.easy;

import leetCodeTopInterview.easy.utils.ArrayPrinter;

public class MoveZeroes {
    //problem: https://leetcode.com/problems/move-zeroes/
    public static void main(String []args){
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        ArrayPrinter.printArray(nums);
    }

    public static void moveZeroes(int[] nums){
        int lastZeroIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastZeroIndex++] = nums[i];
            }
        }
        for(int i = lastZeroIndex; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
