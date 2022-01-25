 private boolean isMin(int[] nums, int mid) {
        int lVal = (mid - 1 > 0) ? nums[mid-1] : Integer.MAX_VALUE;
        int rVal = (mid + 1 < nums.length) ? nums[mid + 1] : Integer.MAX_VALUE;
        
        if(nums[mid] < lVal && nums[mid] < rVal) return true;
        
        return false;
    }
    
    private boolean isMax(int[] nums, int mid) {
        int lVal = (mid - 1 > 0) ? nums[mid-1] : Integer.MIN_VALUE;
        int rVal = (mid + 1 < nums.length) ? nums[mid + 1] : Integer.MIN_VALUE;
        
        if(nums[mid] > lVal && nums[mid] > rVal) return true;
        
        return false;
    }
    
    public int findMin(int[] nums) {
        
        if(nums[0] < nums[nums.length-1]) return nums[0];
        
        int lo = 0;
        int hi  = nums.length-1;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if(isMin(nums,mid)) { //is minimum
                return nums[mid];
            } 
            
            else if(isMax(nums,mid)) { //is maximum
                return nums[mid + 1]; //this will be min
            }
            
            else if(nums[lo] < nums[mid]) { //is left part sorted-> discard the left part
                lo = mid + 1;
            }
            
            else if(nums[mid] < nums[hi]) { //is right part sorted-> discard the right part
                hi = mid - 1;
            }
        }
        
        return 0;
    }
