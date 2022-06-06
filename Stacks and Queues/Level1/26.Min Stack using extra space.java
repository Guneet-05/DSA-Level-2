class MinStack {

    Stack<Integer> dataS;
    Stack<Integer> minS;
    int min;
    
    public MinStack() {
       dataS = new Stack<>();
       minS = new Stack<>();
       min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        dataS.push(val);
        min = (minS.size() == 0) ? Integer.MAX_VALUE : minS.peek();
        if(min < val)
            minS.push(min);
        else 
            minS.push(val);
    }
    
    public void pop() {
        if(dataS.size() == 0) return;
        dataS.pop();
        minS.pop();
        
        if(minS.size() == 0) min = Integer.MAX_VALUE;
    }
    
    public int top() {
        if(dataS.size() == 0) return -1;
        return dataS.peek();
    }
    
    public int getMin() {
        if(dataS.size() == 0) return -1;
        return minS.peek();
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
