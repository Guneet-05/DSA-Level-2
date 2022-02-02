class Solution {
    
    public boolean isPossible(int midSpeed,int []piles, int h) {
        
        int currHours = 0;
        
        for(int i=0;i<piles.length;i++) {
            currHours = currHours + piles[i]/midSpeed;
            if(piles[i] % midSpeed != 0) currHours++;
        }
        
        if(currHours <= h) return true;
        return false;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        
        int lo = 1;
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++) {
            max = Math.max(piles[i],max);
        }
        
        int hi = max;
        int pa = piles.length;
        while(lo <= hi) {
            int midSpeed = lo + (hi-lo)/2;
            
            if(isPossible(midSpeed,piles,h)) {
                pa = midSpeed;
                hi = midSpeed -1;
            } else {
                lo = midSpeed +1;
            }
        }
        
        return pa;
    }
}
