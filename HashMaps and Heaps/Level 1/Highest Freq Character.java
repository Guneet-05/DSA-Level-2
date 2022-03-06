import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        HashMap<Character,Integer> fmap = new HashMap<>();
        
        for(int i=0;i<str.length();i++) {
            fmap.put(str.charAt(i),fmap.getOrDefault(str.charAt(i),0) + 1);
        }
        
        char ans = '0';
        int maxFreq = 0;
        for(Character ch : fmap.keySet()) {
            if(fmap.get(ch) > maxFreq) {
                ans = ch;
                maxFreq = fmap.get(ch);
            }
        }
        
        System.out.println(ans);
    }

}
