import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static long xpown(long x, long n, long m) {
		if(n == 0) return 1;

		long xpnby2 = xpown(x,n/2,m);

		if(n % 2 == 0) 
		  return ((xpnby2)%m * (xpnby2)%m)%m;
		
		return (((x)%m * (xpnby2)%m)%m * (xpnby2)%m)%m;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
			long x = scn.nextLong();
			long n = scn.nextLong();

            long ans = xpown(x,n,1000000007);
			System.out.println(ans);
		}
}
