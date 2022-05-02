import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(highestPowerOf2(n));
        scn.close();
    }

    public static int highestPowerOf2(int n) {
        String bin = Integer.toBinaryString(n);

        int res = 0;
        for(int i=1;i<=bin.length();i++) {
            int curr = (1 << i);
            if(curr > n) break;
            res = curr;
        }

        return res;
    }
}
