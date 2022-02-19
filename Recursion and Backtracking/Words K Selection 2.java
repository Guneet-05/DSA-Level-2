import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(List<Character> chs,int li,int k,String comb) {
     
     if(comb.length() == k) {
       System.out.println(comb);
       return;
     }

     for(int i=li + 1;i<chs.size();i++) {
        combinations(chs,i,k,comb + chs.get(i));
     }
  }

  public static void main(String[] args){
      Scanner scn = new Scanner(System.in);
      String str = scn.nextLine();
      int k = scn.nextInt();

      HashSet<Character> hs = new HashSet<>();
      for(int i=0;i<str.length();i++) {
        hs.add(str.charAt(i));
      }
      
      List<Character> chs = new ArrayList<>();
      for(Character ch: hs) {
        chs.add(ch);
      }


      combinations(chs,-1,k,"");
  }

}
