import java.io.*;

public class Main {
	static int N, K, min;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			map = new int[N][N];
			visited = new boolean[N];
			for(int i = 0; i < N; i++) {
				str = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			//플로이드 와샬
			for(int k = 0; k < N; k++) 
				for(int i = 0; i < N; i++) 
					for(int j = 0; j < N; j++) 
						if(map[i][j] > map[i][k] + map[k][j])
							map[i][j] = map[i][k] + map[k][j];
	
			
			min = Integer.MAX_VALUE;
			System.out.println(DFS(K, 0, 0));
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	static int DFS(int src, int sum, int cnt) {
		if(cnt == N) return sum;
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int ans = DFS(i, sum + map[src][i], cnt + 1);
				if(min > ans) min = ans;
				visited[i] = false;
			}
		}
		return min;
	}
}
