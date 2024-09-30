class CustomStack {
    int[] stack;
    int top;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if(top < stack.length - 1) stack[++top] = x;
    }
    
    public int pop() {
       return top == -1 ? -1 : stack[top--];
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k, stack.length); i++) stack[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */