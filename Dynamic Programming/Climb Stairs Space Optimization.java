import java.io.*;
import java.util.*;

public class Main {

    public static int solve(int n) {
       
        int nm3 = 0, nm2=0, nm1=1;
        int res = 0;
        for(int i=1;i<=n;i++) {
            res = nm1 + nm2 + nm3;
            nm3 = nm2;
            nm2 = nm1;
            nm1 = res;
        }
        
        return res;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solve(n));
    }

}
