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
    

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here

        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();

        for(int i=0;i<intervals.size();i++) {
            start.add(intervals.get(i).start);
        }

        for(int i=0;i<intervals.size();i++) {
            end.add(intervals.get(i).end);
        }

        Collections.sort(start);
        Collections.sort(end);

        int rooms = 0, maxRooms = 0, i = 0, j = 0;

        while(i < start.size()) {
            if(start.get(i) < end.get(j)) {
                i++;
                rooms++;
                maxRooms = Math.max(rooms,maxRooms);
            } else if(start.get(i) > end.get(j)) {
                j++;
                rooms--;
            } else {
                i++;
                j++;
            }
        }

        return maxRooms;
    }
}
