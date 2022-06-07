class CustomStack {
    
    int[] arr;
    int size = 0;
    int top = -1;
    
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if(size == arr.length) return;
        top++;
        arr[top] = x;
        size++;
    }
    
    public int pop() {
        if(size == 0) return -1;
        int val = arr[top];
        top--;
        size--;
        return val;
    }
    
    public void increment(int k, int val) {
        
        for(int i=0;i<k;i++) {
            if(i >= arr.length) break;
            arr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
