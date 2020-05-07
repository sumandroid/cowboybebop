package leetCodeTopInterview.medium;

import java.util.Arrays;

public class FindDuplicateNumber {
    public static void main(String []args){
        int[] nums = new int[]{1,3,4,2,2};
        findDuplicate(nums);
    }

    private static void findDuplicate(int[] nums){
        if(nums == null || nums.length < 2){
            System.out.println("no duplicate element");
            return;
        }
        Arrays.sort(nums);
        int a = nums[0];
        for(int i = 1; i < nums.length; i++){
            a ^= nums[i];
            if(a == 0){
                System.out.println(nums[i]);
                return;
            }
            a = nums[i];
        }

    }
}
