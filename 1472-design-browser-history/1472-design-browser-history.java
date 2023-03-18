class BrowserHistory {
    Stack<String> s1;
    Stack<String> s2;
    public BrowserHistory(String homepage) {
        s1 = new Stack<String>();
        s2 = new Stack<String>();
        s1.push(homepage);
    }
    
    public void visit(String url) {
        s1.add(url);
        s2.clear();
    }
    
    public String back(int steps) {
        for(int i = 0; i < steps; i++){
            if(s1.size() == 1) return s1.peek();
            else {
                s2.add(s1.pop());
            }
        }
        return s1.peek();
    }
    
    public String forward(int steps) { 
        for(int i = 0; i < steps; i++){  
            if(s2.isEmpty()) return s1.peek();          
            if(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */