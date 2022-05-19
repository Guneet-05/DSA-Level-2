class Solution {
    
     public static class Interval {
        int start;
        int end;
        
        Interval() {}
        
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static class MyComparator implements Comparator<Interval> {
        public int compare(Interval obj1,Interval obj2) {
            if(obj1.end >= obj2.end) return 1;
            return -1;
        }
    }
    
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Interval[] intervals = new Interval[n];
        for(int i=0;i<n;i++) {
            intervals[i] = new Interval(points[i][0],points[i][1]);
        }
        
        Arrays.sort(intervals,new MyComparator());

        //last interval's ending time
        int limit = intervals[0].end;
        int count = 1; //count of non overlapping intervals

        
        for(int i=1;i<intervals.length;i++) {
            if((int)limit < intervals[i].start) {
                count++;
                limit = intervals[i].end;
            }
        }

        return count;  
    }
}
