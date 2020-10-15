import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long M = sc.nextInt();
		long[] trees = new long[N];
		for(int i = 0; i < N; i++) {
			trees[i] = sc.nextLong();
		}
		
		Arrays.sort(trees);
		long left = 1, right = trees[N - 1], mid = 0;
		
		while(left <= right) {
			mid = (left + right) / 2;
			if(isPassed(N, M, trees, mid)) {
				left = mid + 1;
			}
			else right = mid - 1;
		}
		
		System.out.println(right);
	}
	static boolean isPassed(int N, long M, long[] trees, long mid) {
		long len = 0;
		
		for(int i = 0; i < N; i++) {
			long trunc = trees[i] - mid;
			if(trunc > 0) len += trunc;
		}
		
		if(len >= M) return true;
		else return false;
	}
}