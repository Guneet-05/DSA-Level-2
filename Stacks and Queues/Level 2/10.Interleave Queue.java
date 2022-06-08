import java.util.*;

public class Solution {
    public static void interLeaveQueue(Queue < Integer > q) {
        // Write your code here.
        Queue<Integer> q1 = new ArrayDeque<>();
        int s = q.size();
        
        for(int i=1;i<=s/2;i++) {
            q1.add(q.remove());
        }
        
        Queue<Integer> res = new ArrayDeque<>();
        while(q.size() != 0) {
            res.add(q1.remove());
            res.add(q.remove());
        }
        
        while(res.size() > 0) {
            q.add(res.remove());
        }
    }
}
