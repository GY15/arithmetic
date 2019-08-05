package leetcode.middle.list;

import java.util.Stack;

public class MinStack {
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else{
            minStack.push(Math.min(minStack.peek(),x));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    Stack<Integer> stack;
    Stack<Integer> minStack;
}
