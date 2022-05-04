import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int y = scn.nextInt();
        System.out.println(xor(x,y));
        scn.close();
    }

    public static int xor(int x, int y) {
        return (x | y) & (~x | ~y);
    }
    
}
