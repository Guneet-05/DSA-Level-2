class Solution
{
    int mod = 1000000007;
    public int countWays(int n, int m)
    {
        // Code here
        if(n < m) return 1;
        if(n == m) return 2;
        Deque<Integer> dp = new ArrayDeque<>();
        
        for(int i=1;i<m;i++) {
            dp.add(1); //for states N < M ans is 1
        }
        
        dp.add(2); //for states N = M, ans is 2
        
        for(int i=m+1;i<=n;i++) {
            int ans = (dp.getFirst() + dp.getLast()) % mod;
            dp.removeFirst();
            dp.addLast(ans);
        }
        
        return dp.getLast();
    }
}
