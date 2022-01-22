class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        
        int maxRadius = Integer.MIN_VALUE;
        for(int i=0;i<houses.length;i++) {
            int curr = closest(heaters,houses[i]);
            maxRadius = Math.max(Math.abs(curr-houses[i]),maxRadius);
        }
        
        return maxRadius;
    }
    
       public int lowerBound(int[] arr, int target) {
        
        //we have to return the first occ if found else ceil
        
        int lo = 0;
        int hi = arr.length -1;
        int pa = arr.length;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid] >= target) {
                pa = mid;
                hi = mid -1;
            } else {
                lo = mid + 1;
            }
        }
        
        return pa;
    } 
    
    private int closest(int[] heaters, int house) {
        int lb = lowerBound(heaters,house);
        if(lb == heaters.length) return heaters[lb-1];
        else if(lb == 0) return heaters[0];
        
        else if(Math.abs(house-heaters[lb]) < Math.abs(house-heaters[lb-1])) {
            return heaters[lb];
        }
        
        else return heaters[lb-1];
    }
}
