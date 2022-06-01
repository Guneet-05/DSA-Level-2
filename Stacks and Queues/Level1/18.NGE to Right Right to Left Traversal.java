import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   int[] res = new int[arr.length];
   Stack<Integer> st = new Stack<>();
   res[res.length-1] = -1;
   st.push(res.length-1);
   
   for(int i=res.length-2;i>=0;i--) {
       if(arr[st.peek()] > arr[i]) {
           res[i] = arr[st.peek()];
       } else {
           while(st.size() > 0 && arr[st.peek()] < arr[i]) {
               st.pop();
           }
           if(st.size() == 0) res[i] = -1;
           else res[i] = arr[st.peek()];
       }
       st.push(i);
   }
   
   return res;
 }

}
