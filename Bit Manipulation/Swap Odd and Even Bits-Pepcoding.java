import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    //write your code here
    
    int emask = 0xAAAAAAAA; // 101010...
    int omask = 0x55555555; //010101..
    
    int resEven = (emask & n);
    int resOdd = (omask & n);
    
    resEven = (resEven >> 1);
    resOdd = (resOdd << 1);
    
    int res = (resEven | resOdd);
    System.out.println(res);
  }

}
