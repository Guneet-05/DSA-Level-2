import java.util.*;

public class Main {

	public static int solution(String str, int k) {
		// write your code here
		HashMap<Character,Integer> fmap = new HashMap<>();
		int count = 0,left = 0;

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

			count += (right - left + 1); 
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
