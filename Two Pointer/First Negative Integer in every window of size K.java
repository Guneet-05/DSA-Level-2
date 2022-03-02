class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Integer> que = new ArrayDeque<>();
        for(int i=0;i<K;i++) {
            if(A[i] < 0) que.add(i);
        }
        
        long[] ans = new long[N-K+1];
        ans[0] = que.size() > 0 ? A[que.peek()] : 0;
        
        for(int i=1;i<=N-K;i++) {
            if(A[i-1] < 0) que.remove();
            if(A[i+K-1] < 0) que.add(i+K-1);
            if(que.size() == 0) ans[i] = 0;
            else ans[i] = A[que.peek()];
        }
        
        return ans;
    }
}
