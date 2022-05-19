class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        ArrayList<int[]> merged = new ArrayList<>();
        
        merged.add(intervals[0]);
        
        for(int i=1;i<intervals.length;i++) {
            int[] lastInt = merged.get(merged.size()-1);
            int[] currInt = intervals[i];
            
            //curr interval start time less than end time of last interval -> can merge
            if(currInt[0] <= lastInt[1]) {
                if(lastInt[1] < currInt[1])
                    lastInt[1] = Math.max(lastInt[1],currInt[1]);
            } else { //cant merge
                merged.add(currInt);
            }
        }
        
        int[][] res= new int[merged.size()][2];
        for(int i=0;i<merged.size();i++) {
            res[i] = merged.get(i);
        }
        
        return res;
    }
}
