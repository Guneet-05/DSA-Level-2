class Solution {
    public int longestkSubstr(String str, int k) {
        // code here
        HashMap<Character,Integer> fmap = new HashMap<>();
		int maxLen = 0,left = 0;

		for(int right=0;right < str.length();right++) {
            char ch = str.charAt(right);
			fmap.put(ch,fmap.getOrDefault(ch,0) + 1);

			while(fmap.size() > k) {
				char chl = str.charAt(left);
				int oFreq = fmap.get(chl);
				if(oFreq == 1) fmap.remove(chl);
				else fmap.put(chl,oFreq - 1);
				left++; 
			}

			if(fmap.size() == k) maxLen = Math.max(maxLen,right - left + 1);
			
		}
		if(maxLen == 0) return -1;
		return maxLen;
    }
}
