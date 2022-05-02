class Solution {
    
    public int kerninghans(int n) {
        int counter = 0;
        while(n != 0) {
            int rmsbm = (n & -n);
            n -= rmsbm;
            counter++;
        }
        
        return counter;
    }
    
    public int[] countBits(int n) {
       int[] res = new int[n+1];
        
       for(int i=0;i<=n;i++) {
           res[i] = kerninghans(i);
       } 
        
       return res;
    }
}
