package leetCodeTopInterview.medium;

public class IncreasingTripletSubsequence {

    public static void main(String []args){
        int[] nums = new int[]{1,2,3,4,5};
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        boolean res = false;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i+1]){
                int c = nums[i];
                int d = nums[i+1];
                if(b < c || b < d){
                    res = true;
                    break;
                }
                if(a < c){
                    res = true;
                    break;
                }
                a = c;
                b = d;
            }
        }
        System.out.println(res);
    }
}
