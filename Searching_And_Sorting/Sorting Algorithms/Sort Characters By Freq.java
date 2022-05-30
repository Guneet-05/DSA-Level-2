class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            int oFreq = freq.getOrDefault(ch,0);
            freq.put(ch, oFreq + 1);
        }
        
        ArrayList<Character>[] buckets = new ArrayList[s.length() + 1];
        for(int i=0;i<buckets.length;i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for(Character ch : freq.keySet()) {
            int val = freq.get(ch);
            buckets[val].add(ch);
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int b=buckets.length-1;b>=0;b--) {
            for(Character ch : buckets[b]) {
                for(int f=0;f<b;f++) {
                    sb.append(ch);
                }
            }
        }
        
        return sb.toString();
    }
}
