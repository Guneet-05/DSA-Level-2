class MyCircularDeque {

    int[] arr;
    int size;
    int front;
    int rear;
    
    public MyCircularDeque(int k) {
        arr = new int[k];
        rear = front = size = 0;
    }
    
    public boolean insertFront(int value) {
        if(size == arr.length) return false;
        
        front = (front - 1 + arr.length) % arr.length;
        arr[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size == arr.length) return false;
        
        arr[rear] = value;
        rear = (rear + 1) % arr.length;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size == 0) return false;
        
        front = (front + 1) % arr.length;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0) return false;
        
        rear = (rear - 1 + arr.length) % arr.length;
        size--;
        return true;
    }
    
    public int getFront() {
        if(size == 0) return -1;
        
        return arr[front];
    }
    
    public int getRear() {
        if(size == 0) return -1;
        
        return arr[(rear - 1 + arr.length) % arr.length];
    }
    
    public boolean isEmpty() {
        if(size == 0) return true;
        else return false;
    }
    
    public boolean isFull() {
        if(size == arr.length) return true;
        else return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
