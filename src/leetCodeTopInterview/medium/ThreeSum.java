package leetCodeTopInterview.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String []args){
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int sum = 0 - nums[i];
                int l = i+1;
                int r = nums.length - 1;
                while(l < r){
                    if(nums[l] + nums[r] == sum){
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        l++;
                        r--;
                    }else if( nums[l] + nums[r] < sum){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        for(List<Integer> l : res){
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
