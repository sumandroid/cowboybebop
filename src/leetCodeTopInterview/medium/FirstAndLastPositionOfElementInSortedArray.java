package leetCodeTopInterview.medium;

public class FirstAndLastPositionOfElementInSortedArray {

    public static void main(String []args){
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] res = findFirstAndLastPosition(nums, target);
        System.out.println(res[0] + " " + res[1]);

    }

    private static int[] findFirstAndLastPosition(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int pos = binarySearch(nums, 0, nums.length - 1, target);
        int rightPos = pos;
        if(pos == -1){
            return new int[]{-1,-1};
        }
        if(pos >= 0 && pos < nums.length){
            if(pos > 0){
                if(nums[pos-1] == target){
                    while(pos > 0 && nums[pos-1] == target){
                        pos--;
                    }
                }
            }
            if(rightPos < nums.length - 1){
                int right = nums[pos + 1];
                if(right == target){
                    while(pos < nums.length && nums[rightPos] == nums[rightPos + 1]){
                        rightPos++;
                    }
                }
            }
        }
        return new int[]{pos, rightPos};
    }

    private static int binarySearch(int[] nums, int start, int end, int target){
        if(start < end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(mid > target){
                 return binarySearch(nums, 0, mid - 1, target);
            }else{
                return binarySearch(nums, mid+1, nums.length - 1, target);
            }
        }
        return -1;
    }
}
