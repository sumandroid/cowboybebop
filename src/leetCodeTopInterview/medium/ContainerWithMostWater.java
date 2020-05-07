package leetCodeTopInterview.medium;

public class ContainerWithMostWater {

    public static void main(String []args){
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(getAreaWithMaxWater(heights));
    }

    private static int getAreaWithMaxWater(int[] heights){
        if(heights == null || heights.length < 2){
            return 0;
        }
        int maxArea = 0;
        int l = 0;
        int r = heights.length - 1;
        while (l < r){
            maxArea = Math.max(maxArea, (r-l) * Math.min(heights[l], heights[r]));
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;

    }
}
