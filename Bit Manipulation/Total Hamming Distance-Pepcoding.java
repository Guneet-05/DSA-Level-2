import java.io.*;
import java.util.*;

public class Main {

  public static long solution(int[] arr){
    //write your code here
    long res = 0;
    
    for(int i=0;i<32;i++) {
        long counton = 0;
        for(int val : arr) {
            int bit  = ((val & (1 << i)) == 0) ? 0 : 1;
            if(bit == 1) {
                counton++;
            }
        }
        long countoff = arr.length - counton;
        long curr = counton * countoff * 2;
        res += curr;
    }
    return res;
  }

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < arr.length; i++){
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

}
