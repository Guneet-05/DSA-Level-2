import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    //write your code here
    
    //setting the ith bit
    int maskForSetting = (1 << i); //or with the number
    int maskForOff = ~(1 << j); //and with the number
    int maskForToogle = (1 << k); //XOR with the number;
    int maskForChecking = (1 << m); //and with number
    
    int setBitNo = (n | maskForSetting);
    int unsetBitNo = (n & maskForOff);
    int toggledNo = (n ^ maskForToogle);
    
    System.out.println(setBitNo);
    System.out.println(unsetBitNo);
    System.out.println(toggledNo);
    
    if((n & maskForChecking) != 0) {
        System.out.println(true); //bit was set
    } else {
        System.out.println(false); //bit was off
    }
  }

}
