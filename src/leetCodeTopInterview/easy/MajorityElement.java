package leetCodeTopInterview.easy;

public class MajorityElement {

    //problem: https://leetcode.com/problems/majority-element/

    //implementing boore's moyers voting algo
    public static void main(String []args){
        int[] nums = new int[]{2,2,1,1,1,2,2};
        Integer candidate = null;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                candidate = nums[i];
            }
            count += (candidate == nums[i]) ? 1 : -1;
        }
        System.out.print(candidate);
    }
}
