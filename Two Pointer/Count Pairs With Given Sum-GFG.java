class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        HashMap<Integer,Integer> fmap = new HashMap<>();
        int count = 0;
        
        for(int i=0;i<n;i++) {
            int comp = k - arr[i];
            int compFreq = fmap.getOrDefault(comp,0);
            count += compFreq;
            
            int oFreq = fmap.getOrDefault(arr[i],0);
            fmap.put(arr[i],oFreq + 1);
        }
        
        return count;
    }
}
