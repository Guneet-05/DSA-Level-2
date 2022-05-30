class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int oFreq = freq.getOrDefault(nums[i],0);
            freq.put(nums[i],oFreq + 1);
        }
        
        TreeSet<Integer>[] buckets = new TreeSet[nums.length + 1];
        for(int i=0;i<buckets.length;i++) {
            buckets[i] = new TreeSet<>();
        }
        
        for(Integer x : freq.keySet()) {
            int freqVal = freq.get(x);
            buckets[freqVal].add(x); //x will be added in ordered manner itself
        }
        
        int[] res = new int[nums.length];
        int idx = 0;
        
        for(int b=0;b<buckets.length;b++) {
            for(Integer x : buckets[b].descendingSet()) {
                for(int f=0;f<b;f++) {
                    res[idx++] = x;
                }
            }
        }
        
        return res;
    }
}
