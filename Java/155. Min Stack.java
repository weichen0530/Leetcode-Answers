class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minOrderStack;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minOrderStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minOrderStack.size() == 0){
            minOrderStack.push(val);
        }else{
            while(minOrderStack.size() != 0 && minOrderStack.peek() < val){
                stack.push(minOrderStack.pop());
            }
            minOrderStack.push(val);
            while(minOrderStack.size() != stack.size()){
                minOrderStack.push(stack.pop());
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int val = stack.pop();
        while(minOrderStack.size() != 0 && minOrderStack.peek() != val){
            stack.push(minOrderStack.pop());
        }
        minOrderStack.pop();
        while(minOrderStack.size() != stack.size()){
            minOrderStack.push(stack.pop());
        }
    }
    
    public int top() {
        return stack.isEmpty() ? null: stack.peek();
    }
    
    public int getMin() {
        return minOrderStack.isEmpty() ? null: minOrderStack.peek();
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