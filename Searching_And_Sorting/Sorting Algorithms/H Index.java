class Solution {
    public int hIndex(int[] citations) {
       int[] buckets = new int[citations.length + 2];
        
        for(int citation : citations) {
            if(citation > citations.length) {
                buckets[buckets.length-1]++;
            } else {
                buckets[citation]++;
            }
        }
        
        for(int i=buckets.length-2;i>=0;i--) {
            buckets[i] += buckets[i + 1];
            if(buckets[i] >= i) return i;
        }
        
        return 0;
        
    }
}
