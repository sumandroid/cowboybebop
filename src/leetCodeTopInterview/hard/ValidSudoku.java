package leetCodeTopInterview.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> seen = new HashSet<>();
        Set<Character> seenRow = new HashSet<>();
        Set<Character> seenCol = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j <= 2; j++){
                if(seen.contains(board[i][j])) return false;
                if(board[i][j] != '.' && board[i][j] >= '1' && board[i][j] <= '9'){
                    seen.add(board[i][j]);
                }
                if(j == 2 && (i == 2 || i == 5 || i == 8)){
                    seen.clear();
                }
                int[] nums = new int[]{1,2};
                Arrays.asList(nums);
            }
        }
        for(int i = 0; i < 9; i++){
            for(int j = 3; j <= 5; j++){
                if(seen.contains(board[i][j])) return false;
                if(board[i][j] != '.' && board[i][j] >= '1' && board[i][j] <= '9') seen.add(board[i][j]);
                if( j == 5 && (i == 2 || i == 5 || i == 8)){
                    seen.clear();
                }
            }
        }
        for(int i = 0; i < 9; i++){
            for(int j = 6; j <= 8; j++){
                if(seen.contains(board[i][j])) return false;
                if(board[i][j] != '.' && board[i][j] >= '1' && board[i][j] <= '9') seen.add(board[i][j]);
                if( j == 8 && (i == 2 || i == 5 || i == 8)){
                    seen.clear();
                }
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(seenCol.contains(board[i][j])){
                    return false;
                }
                if(board[i][j] != '.' && board[i][j] >= '1' && board[i][j] <= '9'){
                    seenCol.add(board[i][j]);
                }
                if(seenRow.contains(board[j][i])){
                    return false;
                }
                if(board[j][i] != '.' && board[j][i] >= '1' && board[j][i] <= '9'){
                    seenRow.add(board[j][i]);
                }
            }
            seenRow.clear();
            seenCol.clear();
        }
        return true;
    }
}
