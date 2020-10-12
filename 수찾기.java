import java.util.*;

public class 수찾기 {
	static int[] A= {};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int arr[] = new int[M];
		for(int i = 0; i < M; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(A);
		for(int i = 0; i < M; i++) {
			System.out.println(binarySearch(arr[i]));
		}
	}
	
	public static int binarySearch(int n) {
		int start = 0;
		int end = A.length - 1;
		int mid = (start + end) / 2;
		while(end - start >= 0) {
			if(A[mid] == n) {
				return 1;
			}
			else if(mid < n) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
			mid = (start + end) / 2;
		}
		return 0;
	}
}
