// calculate the square of a number w/o using *,/,%,power()
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(square(n));
        scn.close();
    }

    public static int square(int n) {
        
        if(n == 0) return 0;

        if(n < 0) n = -n;

        //check if the number is even i.e. divisible by 2
        //if a number is divisible by 2, its LSB is 0

        int lsb = (n & 1);
        int x = (n >> 1); //floor(n/2)
        if(lsb == 1) {
            //number is odd
            // 4*x2 + 4 * x + 1 here x = floor(n/2)
            int nby2square = square(x);
            return ((nby2square << 2) + (x << 2) + 1);
        }
        
        // if the number is even
        // 4 * x2

        int nby2square = square(x);
        return (nby2square << 2);

    }
    
}
