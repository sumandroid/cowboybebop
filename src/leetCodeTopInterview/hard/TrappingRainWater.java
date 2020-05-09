package leetCodeTopInterview.hard;

public class TrappingRainWater {

    public static void main(String []args){
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trappedRainWater(heights));
    }

    private static int trappedRainWater(int[] heights){
        int[] leftMaxima = new int[heights.length + 1];
        int water = 0;
        leftMaxima[0] = 0;
        for(int i = 0; i < heights.length; i++){
            leftMaxima[i+1] = Math.max(leftMaxima[i], heights[i]);
        }
        int rightMaxima = 0;
        for(int i = heights.length - 1; i >= 0; i--){
            rightMaxima = Math.max(rightMaxima, heights[i]);
            water += Math.min(leftMaxima[i], rightMaxima) > heights[i] ? Math.min(leftMaxima[i], rightMaxima) - heights[i] : 0;
        }
        return water;
    }
}
