class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> freq = new HashMap<>();
        
        for(String str : words) {
            int oFreq = freq.getOrDefault(str,0);
            freq.put(str,oFreq + 1);
        }
        
        TreeSet<String>[] buckets = new TreeSet[words.length + 1];
        
        for(int i=0;i<buckets.length;i++) {
            buckets[i] = new TreeSet<>();
        }
        
        for(String word : freq.keySet()) {
            int valFreq = freq.get(word);
            buckets[valFreq].add(word);
        }
        
        List<String> res = new ArrayList<>();
        
        for(int i=buckets.length-1;i>=0;i--) {
            if(k == 0) break;
            
            for(String word : buckets[i]) {
                res.add(word);
                k--;
                
                if(k == 0) break;
            }
        }
        
        return res;
    }
}
