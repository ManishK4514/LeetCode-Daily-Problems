class MyQueue {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(st1.empty()) st1.push(x);
        else{
            while(!st1.empty()){
                st2.push(st1.pop());
            }
            st1.push(x);
            while(!st2.empty()){
                st1.push(st2.pop());
            }
        }
    }
    
    public int pop() {
        return st1.pop();
    }
    
    public int peek() {
        return st1.peek();
    }
    
    public boolean empty() {
        return st1.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */