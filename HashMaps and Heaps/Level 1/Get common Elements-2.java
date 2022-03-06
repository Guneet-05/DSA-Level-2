import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] a1 = new int[n1];
    
    HashMap<Integer,Integer> hm1 = new HashMap<>();
    for(int i=0;i<n1;i++) {
        a1[i] = scn.nextInt();
        int oFreq = hm1.getOrDefault(a1[i],0);
        hm1.put(a1[i],oFreq + 1);
    }
    
    int n2 = scn.nextInt();
    int[] a2 = new int[n2];
    HashMap<Integer,Integer> hm2 = new HashMap<>();
    for(int i=0;i<n2;i++) {
        a2[i] = scn.nextInt();
        int oFreq = hm2.getOrDefault(a2[i],0);
        hm2.put(a2[i],oFreq + 1);
    }
    
    for(int ele : a2) {
        if(hm2.get(ele) > 0) {
            if(hm1.containsKey(ele) && hm1.get(ele) > 0) {
                System.out.println(ele);
                hm1.put(ele, hm1.get(ele) - 1);
                hm2.put(ele, hm2.get(ele) - 1);
            }
        }
    }
    
 }

}
