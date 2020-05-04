package leetCodeTopInterview.medium;

public class FirstBadVersion {

    public static class Solution {
        int badVersion = -1;
        public int firstBadVersion(int n) {
            return badVersion(0, n);
        }

        public int badVersion(int start, int end) {
            if (start < end) {
                int mid = (start + end) / 2;
                if (!isBadVersion(mid)) {
                    badVersion(mid + 1, end);
                } else {
                    if (isBadVersion(mid - 1)) {
                        badVersion(0, mid - 1);
                    }
                    badVersion = mid;
                }
            }
            return -1;
        }

        private boolean isBadVersion(int n){
            if(n==4){
                return true;
            }
            return false;
        }
    }

    public static void main(String []args){
        Solution solution = new Solution();
        solution.firstBadVersion(5);
        System.out.println(solution.badVersion);

    }
}
