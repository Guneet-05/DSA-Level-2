import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    //write your code here
    
    int en = (n << 3);
    int num = en - n;
    int res = (num >> 3);
    System.out.println(res);
  }

}
