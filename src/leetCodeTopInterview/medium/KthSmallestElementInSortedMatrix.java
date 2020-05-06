package leetCodeTopInterview.medium;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    public static void main(String []args){
        int[][] matrix = new int[][]{{1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
        int k  = 8;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a,b) -> b - a);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(maxHeap.size() >= k){
                    if(maxHeap.peek() > matrix[i][j]){
                        maxHeap.poll();
                        maxHeap.add(matrix[i][j]);
                    }
                }else{
                    maxHeap.add(matrix[i][j]);
                }
            }
        }
        System.out.println("kth largest element = " + maxHeap.poll());
    }
}
