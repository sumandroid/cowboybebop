package leetCodeTopInterview.medium;

public class JumpGame {

    public static void main(String []args){
        int[] nums = new int[]{2,3,1,1,4};
        int lastGoodIndex = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] + i >= lastGoodIndex){
                lastGoodIndex = i;
            }
        }
        System.out.println(lastGoodIndex == 0);
    }
}
