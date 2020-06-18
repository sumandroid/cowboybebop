package miscallaneous;

public class RatInMaze {

    public static void main(String []args){
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        int N = maze.length;
        int solution[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        System.out.println( solveMaze(maze, solution, 0,  0));
    }

    private static boolean solveMaze(int[][] maze, int[][] solution, int i, int j){
        if(i == maze.length - 1 && j == maze[i].length - 1 && maze[i][j] == 1){
            solution[i][j] = 1;
            return true;
        }
        if(isSafe(maze, i, j)){
            solution[i][j] = 1;
            if(solveMaze(maze, solution, i+1, j)){
                return true;
            }
            if(solveMaze(maze, solution, i, j+1)){
                return true;
            }
            solution[i][j] = 0;
            return false;
        }
        return false;
    }

    private static boolean isSafe(int[][] maze, int i, int j){
        if(i < maze.length && i >= 0 && j < maze[i].length && j >= 0 && maze[i][j] == 1){
            return true;
        }
        return false;
    }
}
