package leetCodeTopInterview.easy;

import java.util.Stack;

public class MinStack {

    //problem : https://leetcode.com/problems/min-stack/

    private Stack<Integer> stack;
    private Stack<Integer> minimumStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minimumStack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if(minimumStack.isEmpty() || minimumStack.peek() >= x){
            minimumStack.add(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if(x == minimumStack.peek()) {
            minimumStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimumStack.peek();
    }
}
