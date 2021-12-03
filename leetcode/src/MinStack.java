import java.util.Stack;

class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int val) {
        if( minStack.isEmpty() || val <=  minStack.peek()){   //Push when empty OR x<= current smallest value
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        int val = stack.pop();
        if (minStack.peek() == val) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}