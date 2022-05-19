import java.util.*;


public class Main {
  public static int meetingRooms(int intervals[][]) {
    // write your code here
    int maxRooms = 0;
    Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
    
    Queue<Integer> q = new ArrayDeque<>();
    
    for(int i=0;i<intervals.length;i++) {
        if(q.size() == 0 || q.peek() > intervals[i][0]) {
            maxRooms++;
        } else {
            q.remove();
        }
        q.add(intervals[i][1]);
    }
    
    return maxRooms;
  }
  public static void main(String args[]) {
    Scanner scn = new Scanner(System.in);

    // Input Format
    int n = scn.nextInt();
    int input[][] = new int[n][2];

    for (int i = 0 ; i <  n ; i++) {
      int sp = scn.nextInt();
      int ep = scn.nextInt();

      input[i][0] = sp;
      input[i][1] = ep;
    }

    // Output Format
    System.out.println(meetingRooms(input));
  }
}
