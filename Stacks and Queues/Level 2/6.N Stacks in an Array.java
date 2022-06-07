public class NStack {
    
    int[] arr;
    int[] next;
    int[] top;
    int freeIdx;
    
    public NStack(int K, int N) {
        arr = new int[N];
        
        next = new int[N];
        for(int i=0;i<N;i++) {
            next[i] = i + 1;
        }
        next[N-1] = -1;
        
        top = new int[K];
        for(int i=0;i<K;i++) {
            top[i] = -1;
        }
        
        freeIdx = 0;
    }

    public boolean push(int x, int m) {
        if(freeIdx == -1) {
            return false;
        }
        
        int currIdx = freeIdx;
        
        //fill element in the array
        arr[currIdx] = x;
        
        //update freeIdx to next free idx
        freeIdx = next[freeIdx];
        
        //Update next to the previous element's index of mth stack
        next[currIdx] = top[m-1];
        
        //make curr element index at top of mth stack
        top[m - 1] = currIdx;
        return true;
    }

    public int pop(int m) {
        if(top[m-1] == -1) {
            //Stack underflow
            return -1;
        }
        
        int currIdx = top[m - 1];
        top[m - 1] = next[currIdx];
        next[currIdx] = freeIdx;
        
        //Make current index at freeIdx
        freeIdx = currIdx;
        return arr[currIdx];
    }
}
