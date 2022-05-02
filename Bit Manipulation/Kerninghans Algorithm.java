import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    int counter = 0;
    while(n != 0) {
        int rmsbm = (n & -n);
        n -= rmsbm;
        counter++;
    }
    
    System.out.println(counter);
  }

}
