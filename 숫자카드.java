import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long cards[] = new long[N];
		for(int i = 0; i < N; i++)
			cards[i] = sc.nextLong();
		
		int M = sc.nextInt();
		long[] isOwn = new long[M];
		for(int i = 0; i < M; i++)
			isOwn[i] = sc.nextLong();
		sc.close();
		
		Arrays.sort(cards);
		for(int i = 0; i < M; i++) {
			if(binarySearch(isOwn[i], cards)) System.out.print(1 + " ");
			else System.out.print(0 + " ");
		}
	}
	
	static boolean binarySearch(long n, long[] arr) {
		int left = 0, right = arr.length - 1, mid = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			if(arr[mid] < n) left = mid + 1;
			else if(arr[mid] > n) right = mid - 1;
			else return true;
		}
		return false;
	}
}