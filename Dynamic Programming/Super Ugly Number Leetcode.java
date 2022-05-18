class Solution {
    //TC = O(N * K) Space: O(N + K)
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ptr = new int[primes.length];
        
        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);
        
        for(int i=1;i<n;i++) {
            int min = Integer.MAX_VALUE;
            
            for(int j=0;j<primes.length;j++) {
                int idx = ptr[j];
                min = Math.min(min,ugly.get(idx) * primes[j]);
            }
        
            ugly.add(min);
            
            //updating all pointers that have min value
            for(int j=0;j<primes.length;j++) {
                if(ugly.get(ptr[j]) * primes[j] == min) {
                    ptr[j]++;
                }
            }
        
        }
        
        return ugly.get(n-1);
        
    }
}
