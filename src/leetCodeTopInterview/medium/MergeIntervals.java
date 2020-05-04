package leetCodeTopInterview.medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

    public static void main(String []args){
        int[][] intervals = new int[][] {{1,3}, {2,6}, {8,10}, {15,18}};
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] i : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < i[0]){
                merged.add(i);
            }else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);
            }
        }
    }



    private static class IntervalComparator implements Comparator<int[]> {

        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }
}
