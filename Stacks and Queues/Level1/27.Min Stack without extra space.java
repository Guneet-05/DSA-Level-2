class MinStack {
    Stack<Long> stk = new Stack<>();
    long min = Long.MAX_VALUE;
    
    public void push(int val) {
        if(stk.size() == 0) {
            stk.push(1l * val);
            min = (long)val;
        } else {
            //Encrypt the value if it is less than min
            if(val < min) {
                stk.push(2l * val - min);
                min = (long)val;
            } else {
                stk.push(1l * val);
            }
        }
    }
    
    public void pop() {
        if(stk.size() == 0) return;
        
        //check if top is encrypted
        if(stk.peek() < min) {
            //decrypt the prev min
            min = 2l * min - stk.pop();
        } else {
            stk.pop();
        }
    }
    
    public int top() {
        if(stk.size() == 0) return - 1;
        
        //check if top is encrypted
        if(stk.peek() < min) {
            //decrypt the prev min
            return (int)min;
        } 
        
        long top = stk.peek();
        return (int)top;
    }
    
    public int getMin() {
        if(stk.size() == 0) return -1;
        
        return (int)min;
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
