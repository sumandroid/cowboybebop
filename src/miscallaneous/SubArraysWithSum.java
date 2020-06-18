package miscallaneous;

import leetCodeTopInterview.medium.ExpressionTree;

import java.util.*;

public class SubArraysWithSum {

    public static void main(String []args){
        int[] arr = {10,2,-2,-20,10};
        int sum = -10;
        int res = findSubArraysWithSum(arr, sum);
        System.out.println("No. of subarrays: " + res);
    }

    static int findSubArraysWithSum(int[] arr, int sum){
        int currSum = 0;
        int res = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            currSum += arr[i];
            if(currSum == sum){
                res++;
            }
            if(sumMap.containsKey(currSum - sum)){
                res += sumMap.get(currSum - sum);
            }
            Integer count = sumMap.get(currSum);
            if(count == null){
                sumMap.put(currSum, 1);
            }else{
                sumMap.put(currSum, count + 1);
            }
        }
        return res;
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        HashMap<TreeNode, Integer> nodeToLevelMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        populateNodeToLevelMap(nodeToLevelMap, 0, root);
        queue.add(root);
        map.put(0, Arrays.asList(0));

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    if(!map.containsKey(nodeToLevelMap.get(node.left))){
                        map.put(nodeToLevelMap.get(node.left), new ArrayList<>());
                    }
                    map.get(nodeToLevelMap.get(node.left)).add(node.left.val);
                    queue.add(node.left);
                }
                if(node.right != null){
                    if(!map.containsKey(nodeToLevelMap.get(node.right))){
                        map.put(nodeToLevelMap.get(node.right), new ArrayList<>());
                    }
                    map.get(nodeToLevelMap.get(node.right)).add(node.right.val);
                    queue.add(node.right);
                }

            }
        }

        for(Integer key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }

    private void populateNodeToLevelMap(HashMap<TreeNode, Integer> map, int level, TreeNode root){
        if(root == null){
            return;
        }
        map.put(root, level);
        populateNodeToLevelMap(map, level - 1, root.left);
        populateNodeToLevelMap(map, level + 1, root.right);
    }

    private  class TreeNode {
        private Integer val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Integer val) {
            this.val = val;
        }
    }
}
