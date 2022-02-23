import java.util.*;

public class Main {
	
    public static int solve(int[][] num1, int[][] num2, int k) {
		// write your code here
         HashMap<Integer,Integer> fmap = new HashMap<>();
         int n = num1.length;
		 int ans = 0;
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<n;j++) {
				 int oFreq = fmap.getOrDefault(num1[i][j],0);
				 fmap.put(num1[i][j],oFreq + 1);
			 }
		 }

		 for(int i=0;i<n;i++) {
			 for(int j=0;j<n;j++) {
				 int comp = k - num2[i][j];
				 int compFreq = fmap.getOrDefault(comp,0);
				 ans += compFreq;
			 }
		 }

		 return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] mat1 = new int[N][N];
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				mat1[i][j] = sc.nextInt();
			}
		}

		int[][] mat2 = new int[N][N];
		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
				mat2[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		System.out.println(solve(mat1, mat2, K));

	}

}
