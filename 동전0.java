import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, K;
	static int[] coin;
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]); K = Integer.parseInt(str[1]);
			coin = new int[N];
			for(int i = 0; i < N; i++) coin[i] = Integer.parseInt(br.readLine());
			br.close();
			
			Arrays.sort(coin);
			System.out.println(greedy());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static int greedy() {
		int sum = 0, idx = 0, cnt = 0;
		while(sum < K) {
			for(int i = 0; i < N; i++) {
				if((sum + coin[i]) <= K) {
					idx = i;
				}
				else break;
			}
			sum += coin[idx];
			cnt++;
		}
		return cnt;
	}
}
