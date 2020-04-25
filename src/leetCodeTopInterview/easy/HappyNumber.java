package leetCodeTopInterview.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    //problem: https://leetcode.com/problems/happy-number/
    public static void main(String []args){
        int num = 19;
        System.out.println(isHappy(num));
    }

    public static boolean isHappy(int num){
        Set<Integer> seen = new HashSet<>();
        while(num != 1){
            int sum = 0;
            int current = num;
            while(current != 0){
                sum += (current % 10) * (current % 10);
                current = current / 10;
            }
            if(seen.contains(sum)){
                return false;
            }
            seen.add(sum);
            num = sum;
        }
        return true;
    }
}
