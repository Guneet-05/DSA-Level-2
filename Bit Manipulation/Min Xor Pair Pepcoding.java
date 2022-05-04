import java.io.*;
import java.util.*;

public class Main {

    public static void solution(int[] A) {
        //write your code here
        Arrays.sort(A);

        int minVal = Integer.MAX_VALUE;

        for(int i=0;i<A.length -1;i++) {
            int xor = (A[i] ^ A[i+1]);
            minVal = Math.min(minVal,xor); 
        }
        
        for(int i=0;i<A.length -1;i++) {
            int xor = (A[i] ^ A[i+1]);
            if(xor == minVal) {
                System.out.println(A[i] + ", " + A[i+1]);
            } 
        }

        
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
    
    
}
