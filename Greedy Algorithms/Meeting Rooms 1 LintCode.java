/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    
    public static class MyComparator implements Comparator<Interval> {
        public int compare(Interval obj1,Interval obj2) {
            if(obj1.end == obj2.end) return obj1.start - obj2.start;
            return obj1.end - obj2.end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals,new MyComparator());

        //last interval's ending time
        int limit = Integer.MIN_VALUE;
        int count = 0; //count of non overlapping intervals

        for(int i=0;i<intervals.size();i++) {
            if(limit > intervals.get(i).start) {
                return false;
            }
            limit = intervals.get(i).end;
        }

        return true;
    }
}
