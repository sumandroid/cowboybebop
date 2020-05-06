package leetCodeTopInterview.medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String []args){
        int[] nums = new int[]{3,30,34,5,9};
        String res = "";
        String[] stringNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            stringNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(stringNums, new StringComparator());
        if(stringNums[0].equals("0")){
            System.out.println("0");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < stringNums.length; i++){
            stringBuilder.append(stringNums[i]);
        }
        System.out.println(stringBuilder.toString());
    }

    private static class StringComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            String a = o1 + o2;
            String b = o2 + o1;
            return b.compareTo(a);
        }
    }
}
