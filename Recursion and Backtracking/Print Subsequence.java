import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       String str = scn.next();
       printSS(str,0,"");
    }

    public static void printSS(String str,int idx, String ans) {
        
        if(idx == str.length()) {
            System.out.println(ans);
            return;
        }

        
        //yes call
        printSS(str,idx + 1, ans + str.charAt(idx));

        //no call
        printSS(str, idx + 1,ans);

    }

}
