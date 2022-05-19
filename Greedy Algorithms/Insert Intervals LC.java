class Solution {
    
    public int findFirst(int[][] intervals,int[] interval) {
        
        for(int i=0;i<intervals.length;i++) {
            if(intervals[i][1] >= interval[0]) return i;
        }
        
        return intervals.length;
    } 
    
    public int findLast(int[][] intervals,int[] interval) {
        for(int i=intervals.length-1;i>=0;i--) {
            if(intervals[i][0] <= interval[1]) return i;
        }
        
        return -1;
    }
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int firstIdx = findFirst(intervals,newInterval);
        int lastIdx = findLast(intervals,newInterval);
        
        //non merging -> firstIdx > lastIdx
        
        
        ArrayList<int[]> res = new ArrayList<>();
        
        if(firstIdx > lastIdx) {
            
            for(int i=0;i<=lastIdx;i++) {
                res.add(intervals[i]);
            }
            
            res.add(newInterval);
            
            for(int i=firstIdx;i<intervals.length;i++) {
                res.add(intervals[i]);
            }
            
            
        } else {
            for(int i=0;i<firstIdx;i++) {
                res.add(intervals[i]);
            }
            
            int[] merged = new int[2];
            merged[0] = Math.min(intervals[firstIdx][0],newInterval[0]);
            merged[1] = Math.max(intervals[lastIdx][1],newInterval[1]);
            
            res.add(merged);
            
            for(int i=lastIdx + 1;i<intervals.length;i++) {
                res.add(intervals[i]);
            }
            
        }
        
        int[][] ans= new int[res.size()][2];
        for(int i=0;i<res.size();i++) {
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}
