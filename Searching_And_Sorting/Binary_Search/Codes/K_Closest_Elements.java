class Solution {
      public static int lowerBound(int[] arr, int target) {
        
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
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int ceil = lowerBound(arr,x);
        int floor = ceil -1;
        
        List<Integer> ans = new ArrayList<>();
        
        while(floor >= 0 && ceil < arr.length && k-- > 0) {
            if(Math.abs(x-arr[floor]) <= Math.abs(arr[ceil]-x)) {
                ans.add(arr[floor]);
                floor--;
            } else {
                ans.add(arr[ceil]);
                ceil++;
            }
        }
        
        while(floor >= 0 && k-- > 0) {
            ans.add(arr[floor]);
            floor--;
        }
        
        while(ceil < arr.length && k-- > 0) {
            ans.add(arr[ceil]);
            ceil++;
        }
        
        Collections.sort(ans);
        return ans;
    }
}
