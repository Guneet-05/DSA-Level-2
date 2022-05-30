class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            int oFreq = freq.getOrDefault(nums[i],0);
            freq.put(nums[i],oFreq + 1);
        } 
        
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        
        for(int i=0;i<buckets.length;i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for(Integer ele : freq.keySet()) {
            int valFreq = freq.get(ele);
            buckets[valFreq].add(ele);
        }
        
        int[] res = new int[k];
        int idx = 0;
        for(int i=buckets.length-1;i>=0;i--) {
            
            if(k == 0) break;
            
            for(int ele : buckets[i]) {
                res[idx++] = ele;
                k--;
                
                if(k == 0) break;
            }
        }
        
        return res;
    }
}
