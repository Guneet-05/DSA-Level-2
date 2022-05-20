class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here 
        Collections.sort(a);
        long ans = Long.MAX_VALUE;
        for(int w=0;w<=(int)(n-m);w++) {
            long max = a.get(w + (int)m -1);
            long min = a.get(w);
            ans = Math.min(ans,max-min);
        }
        
        return ans;
    }
}
