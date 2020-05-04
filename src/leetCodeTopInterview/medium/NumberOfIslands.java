package leetCodeTopInterview.medium;

public class NumberOfIslands {

    public static void main(String []args){
        char[][] grid = new char[][]{{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count += bfs(grid, i, j);
                }
            }
        }
        System.out.println("count = " + count);
    }

    private static int bfs(char[][] grid, int i, int j){
        if(i < 0 || i > grid.length || j < 0 || j > grid[i].length || grid[i][j] == '0'){
            return 0;
        }
        grid[i][j] = '0';
        bfs(grid, i+1, j);
        bfs(grid, i-1, j);
        bfs(grid, i, j+1);
        bfs(grid, i, j-1);
        return 1;
    }
}
