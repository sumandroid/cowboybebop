package leetCodeTopInterview.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String []args){
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6 }, {7, 8, 9}};
        int r1 = 0, r2 = matrix.length-1;
        int c1 = 0, c2 = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while(r1 <= r2 && c1 <= c2){
            for(int c = c1; c <= c2; c++){
                res.add(matrix[r1][c]);
            }
            for(int r = r1 + 1; r <= r2; r++){
                res.add(matrix[r][c2]);
            }
            if(r1 < r2 && c1 < c2){
                for(int c = c2-1; c > c1; c--){
                    res.add(matrix[r2][c]);
                }
                for(int r = r2; r > r1; r--){
                    res.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        for(Integer i : res){
            System.out.print(i);
        }
        System.out.println();
    }
}
