//This is box on level approach

import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int cb, int tb,int ti,String combination,int isf){
    // write your code here

    if(cb == tb) {
      if(isf == ti) {
        System.out.println(combination);
      }
      return;
    }

    //yes 
    combinations(cb + 1,tb,ti,combination + "i",isf + 1);

    //no
    combinations(cb + 1,tb,ti,combination + "-",isf);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(0,nboxes,ritems,"",0);
  }

}
