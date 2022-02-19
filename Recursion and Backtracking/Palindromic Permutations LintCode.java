public class Solution {
    /**
     * @param s: the given string
     * @return: all the palindromic permutations (without duplicates) of it
     */
    List<String> ans;
    public void generatepw(int cb,HashMap<Character,Integer> fmap, StringBuilder currPerm) {
		if(cb == currPerm.length()/2) {
			ans.add(currPerm.toString());
			return;
		}

		for(char ch: fmap.keySet()) {
			if(fmap.get(ch) > 0) {
			    int oFreq = fmap.get(ch);
    			fmap.put(ch,oFreq-2);
    			currPerm.setCharAt(cb,ch);
    			currPerm.setCharAt(currPerm.length() - 1 - cb,ch);
    
    			generatepw(cb + 1,fmap,currPerm);
    
    			fmap.put(ch,oFreq);
    			currPerm.setCharAt(cb,'0');
    			currPerm.setCharAt(currPerm.length() - 1 - cb,'0');

			}
		}
	}

    public List<String> generatePalindromes(String str) {
        // write your code here
        HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		
		StringBuilder currPerm = new StringBuilder("");

		for(int i=0;i<str.length();i++) {
			currPerm.append("0");
		}

		char oddFreqChar = '0';
        
		for(char key: fmap.keySet()) {
			if(fmap.get(key) % 2 == 1) {
				if(oddFreqChar != '0') {
					return new ArrayList<>();
				}
				oddFreqChar = key;
			}
		}

		if(str.length() % 2 == 1) { 
            currPerm.setCharAt(str.length()/2,oddFreqChar);
			int oFreq = fmap.get(oddFreqChar);
			fmap.put(oddFreqChar,oFreq - 1);
		}

        ans = new ArrayList<>();
		generatepw(0,fmap,currPerm);
        return ans;
    }
}
