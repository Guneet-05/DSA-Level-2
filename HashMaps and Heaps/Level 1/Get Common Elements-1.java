import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] a1 = new int[n1];
    HashSet<Integer> hs1 = new HashSet<>();
    for(int i=0;i<n1;i++) {
        a1[i] = scn.nextInt();
        hs1.add(a1[i]);
    }
    
    int n2 = scn.nextInt();
    int[] a2 = new int[n2];
    HashSet<Integer> hs2 = new HashSet<>();
    for(int i=0;i<n2;i++) {
        a2[i] = scn.nextInt();
        hs2.add(a2[i]);
    }
    
    for(int i=0;i<a2.length;i++) {
        if(hs2.contains(a2[i]) && hs1.contains(a2[i])) {
            System.out.println(a2[i]);
            hs2.remove(a2[i]);
        }
    }
    
 }

}
