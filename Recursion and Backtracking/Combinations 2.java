// This is items on Level Approach
// We have converted permuations (items on Level) to combination (items on Level)
import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int[] boxes, int currentItem, int totalItem,int li){
    // write your code here
    if(currentItem == totalItem) {
      for(int val : boxes) {
        if(val == 0) System.out.print("-");
        else System.out.print("i");
      }
      System.out.println();
      return;
    }
    
    //place items in the box
    for(int i=li + 1;i<boxes.length;i++) {
      if(boxes[i] == 0) { //nothing is placed here
         boxes[i] = currentItem + 1;
         combinations(boxes,currentItem + 1,totalItem,i);
         boxes[i] = 0;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 0, ritems,-1);
  }

}
