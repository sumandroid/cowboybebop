package leetCodeTopInterview.medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String []args){
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            maxHeap.add(nums[i]);
        }
        for(int i = 0; i < k - 1; i++){
            maxHeap.poll();
        }
        System.out.println("kth largest element = " + maxHeap.poll());
    }
}
