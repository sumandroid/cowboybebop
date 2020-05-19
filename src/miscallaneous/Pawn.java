package miscallaneous;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn {
    public static int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    public static int maxCellsCovered = 0;

    public static int[] north = {0, -3};
    public static int[] south = {0, 3};
    public static int[] east = {3, 0};
    public static int[] west = {-3, 0};
    public static int[] northEast = {2, -2};
    public static int[] northWest = {-2, -2};
    public static int[] southEast = {2, 2};
    public static int[] southWest = {-2, 2};

    public static List<List<Integer>> visitedNodes = new ArrayList<>();


    public static void main(String[] args) {
        int MAX_ITERATION = 1000000;
        int iterations = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int currentX = j;
                int currentY = i;
                String direction = "clockWise";
                board[currentY][currentX] = 1;
                visitedNodes.add(Arrays.asList(0, 0));
                while (visitedNodes.size() <= 100 && iterations++ <= MAX_ITERATION) {
                    int[] nextMove = getNextMove(currentX, currentY, direction);
                    if (nextMove[0] == 0 && nextMove[1] == 0) {
                        break;
                    }
                    while (currentX + nextMove[0] <= 9 && currentX + nextMove[0] >= 0
                            && currentY + nextMove[1] <= 9 && currentY + nextMove[1] >= 0
                            && board[currentY + nextMove[1]][currentX + nextMove[0]] != 1) {
                        currentX += nextMove[0];
                        currentY += nextMove[1];
                        if (board[currentY][currentX] != 1) {
                            visitNextTile(currentX, currentY);
                            printBoard();
                        } else {
                            break;
                        }
                    }
                }
                clearBoard();
                if(visitedNodes.size() > maxCellsCovered){
                    maxCellsCovered = visitedNodes.size();
                }
                if (visitedNodes.size() != 100) {
                    System.out.println("Program terminated");
                } else {
                    System.out.println("Path found");
                    return;
                }
                visitedNodes.clear();

            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int currentX = j;
                int currentY = i;
                String direction = "aclockWise";
                board[currentY][currentX] = 1;
                visitedNodes.add(Arrays.asList(0, 0));
                while (visitedNodes.size() <= 100 && iterations++ <= MAX_ITERATION) {
                    int[] nextMove = getNextMove(currentX, currentY, direction);
                    if (nextMove[0] == 0 && nextMove[1] == 0) {
                        break;
                    }
                    while (currentX + nextMove[0] <= 9 && currentX + nextMove[0] >= 0
                            && currentY + nextMove[1] <= 9 && currentY + nextMove[1] >= 0
                            && board[currentY + nextMove[1]][currentX + nextMove[0]] != 1) {
                        currentX += nextMove[0];
                        currentY += nextMove[1];
                        if (board[currentY][currentX] != 1) {
                            visitNextTile(currentX, currentY);
                            printBoard();
                        } else {
                            break;
                        }
                    }
                }
                clearBoard();
                if(visitedNodes.size() > maxCellsCovered){
                    maxCellsCovered = visitedNodes.size();
                }
                if (visitedNodes.size() != 100) {
                    System.out.println("Program terminated");
                } else {
                    System.out.println("Path found");
                    return;
                }
                visitedNodes.clear();

            }
        }
        System.out.println(iterations);
        System.out.println("Max cells covered: " + maxCellsCovered);
    }

    public static int[] getNextMove(int currentX, int currentY, String direction) {
        if ("clockWise".equals(direction)) {
            if (currentY - 3 >= 0 && board[currentY + north[1]][currentX + north[0]] != 1) {
                return north;
            } else if (currentX + 2 <= 9 && currentY - 2 >= 0 && board[currentY + northEast[1]][currentX + northEast[0]] != 1) {
                return northEast;
            } else if (currentX + 3 <= 9 && board[currentY + east[1]][currentX + east[0]] != 1) {
                return east;
            } else if (currentX + 2 <= 9 && currentY + 2 <= 9 && board[currentY + southEast[1]][currentX + southEast[0]] != 1) {
                return southEast;
            } else if (currentY + 3 <= 9 && board[currentY + south[1]][currentX + south[0]] != 1) {
                return south;
            } else if (currentX - 2 >= 0 && currentY + 2 <= 9 && board[currentY + southWest[1]][currentX + southWest[0]] != 1) {
                return southWest;
            } else if (currentX - 3 >= 0 && board[currentY + west[1]][currentX + west[0]] != 1) {
                return west;
            } else if (currentX - 2 >= 0 && currentY - 2 >= 0 && board[currentY + northWest[1]][currentX + northWest[0]] != 1) {
                return northWest;
            }
        } else {
            if (currentY - 3 >= 0 && board[currentY + north[1]][currentX + north[0]] != 1) {
                return north;
            } else if (currentX - 2 >= 0 && currentY - 2 >= 0 && board[currentY + northWest[1]][currentX + northWest[0]] != 1) {
                return northWest;
            } else if (currentX - 3 >= 0 && board[currentY + west[1]][currentX + west[0]] != 1) {
                return west;
            } else if (currentX - 2 >= 0 && currentY + 2 <= 9 && board[currentY + southWest[1]][currentX + southWest[0]] != 1) {
                return southWest;
            } else if (currentY + 3 <= 9 && board[currentY + south[1]][currentX + south[0]] != 1) {
                return south;
            } else if (currentX + 2 <= 9 && currentY + 2 <= 9 && board[currentY + southEast[1]][currentX + southEast[0]] != 1) {
                return southEast;
            } else if (currentX + 3 <= 9 && board[currentY + east[1]][currentX + east[0]] != 1) {
                return east;
            } else if (currentX + 2 <= 9 && currentY - 2 >= 0 && board[currentY + northEast[1]][currentX + northEast[0]] != 1) {
                return northEast;
            }
        }
        return new int[]{0, 0};
    }

    public static void visitNextTile(int currentX, int currentY) {
        board[currentY][currentX] = 1;
        visitedNodes.add(Arrays.asList(currentX, currentY));
    }

    public static void printBoard() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("****************************");
        System.out.println();
    }

    public static void clearBoard() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                board[i][j] = 0;
            }
        }
    }

}
