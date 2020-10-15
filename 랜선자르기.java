import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		int[] cables = new int[K];
		for(int i = 0; i < K; i++) {
			cables[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(cables);
		long left = 1, right = cables[K - 1], mid = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			if(isPassed(N, cables, mid)) left = mid + 1;
			else right = mid - 1;
		}
		System.out.println(right);				
	}
	
	static boolean isPassed(int n, int[] cables, long mid) {
		long num = 0;
		for(int i = 0; i < cables.length; i++) {
			num += cables[i] / mid;
		}
		if(num >= n) return true;
		else return false;
	}
}