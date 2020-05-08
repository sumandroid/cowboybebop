package leetCodeTopInterview.medium;

public class FindStraightLine {

    public static void main(String []args){
        int[][] coordinates = new int[][]{{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
        System.out.println(checkStraightLine(coordinates));
    }

    private static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length < 2){
            return false;
        }
        if(coordinates.length == 2){
            return true;
        }
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        double slope = ((double)y2 - (double)y1)/((double) x2 - (double) x1);
        for(int i = 2; i < coordinates.length; i++){
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            double newSlope = ((double) y- (double) y2)/((double) x - (double) x2);
            if(Double.compare(Math.abs(slope), Math.abs(newSlope)) != 0){
                return false;
            }
            x2 = x;
            y2 = y;
        }
        return true;
    }
}
