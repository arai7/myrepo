class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            int removed = stack.pop();
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }   
    }
    
    public int top() {
        if(stack.size() >= 0)
            return stack.peek();
        return -1;
    }
    
    public int getMin() {
        if(stack.size() >= 0)
            return minStack.peek();
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
