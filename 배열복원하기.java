import java.util.Scanner;

public class Main {
	static int H, W, X, Y;
	static int[][] A, B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		H = sc.nextInt();
		W = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		B = new int[H + X][W + Y];
		A = new int[H][W];
		for(int i = 0; i < H + X; i++) {
			for(int j = 0; j < W + Y; j++) {
				B[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		restore();
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void restore() {
		int arr1[][] = new int[H + X][W + Y];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				arr1[i][j] = 1;
			}
		}
		
		int arr2[][] = new int[H + X][W + Y];
		for(int i = X; i < H + X; i++) {
			for(int j = Y; j < W + Y; j++) {
				arr2[i][j] = 1;
			}
		}
		
		for(int i = 0; i < H + X; i++) {
			for(int j = 0; j < W + Y; j++) {
				if(arr1[i][j] > 0 && arr2[i][j] == 0) {
					A[i][j] = B[i][j];
				}
				else if(arr1[i][j] == 0 && arr2[i][j] > 0) {
					A[i - X][j - Y] = B[i][j];
				}
				else if(arr1[i][j] > 0 && arr2[i][j] > 0) {
					A[i][j] = B[i][j] - A[i - X][j - Y];
				}
			}
		}
	}
}