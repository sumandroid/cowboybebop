package leetCodeTopInterview.medium;

public class ExpressionTree {

    public static void main(String[] args) {
        Node root = new Node("+");
        root.left = new Node("*");
        root.left.left = new Node("5");
        root.left.right = new Node("4");
        root.right = new Node("-");
        root.right.left = new Node("100");
        root.right.right = new Node("20");
        System.out.println(evaluateExpressionTree(root));
    }

    private static int evaluateExpressionTree(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.val);
        }
        int leftSum = evaluateExpressionTree(root.left);
        int rightSum = evaluateExpressionTree(root.right);
        if (root.val.equals("+")) {
            return leftSum + rightSum;
        } else if (root.val.equals("-")) {
            return leftSum - rightSum;
        } else if (root.val.equals("/")) {
            return leftSum / rightSum;
        } else {
            return leftSum * rightSum;
        }
    }


    private static class Node {
        private String val;
        private Node left;
        private Node right;

        public Node(String val) {
            this.val = val;
        }
    }
}
