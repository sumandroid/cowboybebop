package leetCodeTopInterview.easy;

import leetCodeTopInterview.easy.utils.ArrayPrinter;

public class RemoveDuplicatesFromSortedArray {
    //problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    public static void main(String []args){
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int count = removeDuplicates(arr);
        System.out.println(count);
        ArrayPrinter.printArray(arr);
    }

    private static int removeDuplicates(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        if(arr.length == 1){
            return 1;
        }
        int count = 1;
        int lastNonRepeatingIndex = 0;
        for(int i = 1; i < arr.length; i++){
            while(i < arr.length && arr[i] == arr[i-1]){
                i++;
            }
            if(i < arr.length){
                arr[++lastNonRepeatingIndex] = arr[i];
                count++;
            }
        }
        return count;
    }
}
