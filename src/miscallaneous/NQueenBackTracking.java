package miscallaneous;

public class NQueenBackTracking {

    static final int N = 4;

    public static void main(String []args){
        int[][] board = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };
        if(!new NQueenBackTracking().solveForNQ(board, 0)){
            System.out.println("No solution");
        }else{
            new NQueenBackTracking().printSolution(board);
        }
    }

    boolean solveForNQ(int[][] board, int col){
        if(col >= N){
            return true;
        }
        for (int i = 0; i < N; i++){
            if(isSafe(col, i, board)){
                board[i][col] = 1;
                if(solveForNQ(board, col + 1)){
                    return true;
                }
                board[i][col] = 0; //backtrack
            }
        }
        return false;
    }

    boolean isSafe(int col, int row, int[][]board){ //bounding method

        //check for the left side
        for (int i = 0; i < col; i++){
            if(board[row][i] == 1){
                return false;
            }
        }

        //check for left upper diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        // check lower diagonal on left
        for(int i = row, j = col; i < N && j >= 0; i++, j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

}
