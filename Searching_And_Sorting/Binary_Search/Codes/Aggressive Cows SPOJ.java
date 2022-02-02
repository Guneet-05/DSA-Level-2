import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
		
		int t = scn.nextInt();
		
		while(t-- > 0) {
			int N = scn.nextInt();
			int C = scn.nextInt();
			
			int[] stalls = new int[N];
			
			for(int i=0;i<N;i++) {
				stalls[i] = scn.nextInt();
			}
			
			System.out.println(maximizeMinDist(stalls,C));
		}
	}
	
	private static boolean isPossible(int[] stalls,int mid, int cows) {
		int placedCows = 1;
		int placedAt = stalls[0];
		
		for(int i=1;i<stalls.length;i++) {
			if(placedAt + mid <= stalls[i]) {
				placedAt = stalls[i];
				placedCows++;
			}
		} 
		
		if(placedCows < cows) return false;
		return true;
	}
	
	public static int maximizeMinDist(int[] stalls,int cows) {
		
		Arrays.sort(stalls);
		
		int lo = stalls[1]-stalls[0];
		int hi = stalls[stalls.length-1] - stalls[0];
		int pa = 0;
		
		while(lo <= hi) {
			int mid = lo + (hi-lo)/2;
			
			if(isPossible(stalls,mid,cows)) {
				pa = mid;
				lo = mid + 1; //because we have to maximize
			} else {
				hi = mid-1;
			}
		}
		
		return pa;
	}
}
