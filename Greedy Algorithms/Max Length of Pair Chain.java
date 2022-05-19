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
            if(obj1.end == obj2.end) return obj1.start - obj2.start;
            return obj1.end - obj2.end;
        }
    }
    
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Interval[] intervals = new Interval[n];
        for(int i=0;i<n;i++) {
            intervals[i] = new Interval(pairs[i][0],pairs[i][1]);
        }
        
        Arrays.sort(intervals,new MyComparator());

        //last interval's ending time
        int limit = Integer.MIN_VALUE;
        int count = 0; //count of non overlapping intervals

        for(int i=0;i<intervals.length;i++) {
            if(limit < intervals[i].start) {
                count++;
                limit = intervals[i].end;
            }
        }

        return count;   
    }
}
