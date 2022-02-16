// This is item on Level Approach

import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int currentItem, int totalItem){
    // write your code here
    if(currentItem == totalItem) {
      for(int val : boxes) System.out.print(val);
      System.out.println();
      return;
    }
    
    //place items in the box
    for(int i=0;i<boxes.length;i++) {
      if(boxes[i] == 0) { //nothing is placed here
         boxes[i] = currentItem + 1;
         permutations(boxes,currentItem + 1,totalItem);
         boxes[i] = 0;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 0, ritems);
  }

}
