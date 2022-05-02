class Solution
{
    public int kerninghans(int n) {
        int counter = 0;
        while(n != 0) {
            int rmsbm = (n & -n);
            n -= rmsbm;
            counter++;
        }
        
        return counter;
    }
    
    public int is_bleak(int n)
    {
        // Code here
        for(int i=1;i<=n;i++) {
            int setBitCount = kerninghans(i);
            int res = i + setBitCount;
            if(res == n) return 0;
        }
        
        return 1;
    }
}
