import java.io.*;

// 그래프 상에서는 0이어도 여행 경로가 1 -> 1 인 경우 true
public class Main {
	static int N, M;
	static int map[][];
	static boolean visited[];
	static boolean isExist;
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			map = new int[N + 1][N + 1];
			for(int i = 1; i <= N; i++) {
				String str[] = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j + 1] = Integer.parseInt(str[j]);
				}
			}
			
			String str[] = br.readLine().split(" ");
			boolean answer = true;
			for(int i = 0; i < M - 1; i++) {
				visited = new boolean[N + 1];
				isExist = false;
				DFS(Integer.parseInt(str[i]), Integer.parseInt(str[i + 1]));
				if(!isExist) {
					System.out.println("NO");
					answer = false;
					break;
				}
			}
			if(answer) System.out.println("YES");
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static void DFS(int src, int dest) {
		if(src == dest) {
			isExist = true;
			return;
		}
		visited[src] = true;
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && map[src][i] == 1) {
				visited[i] = true;
				DFS(i, dest);
			}
		}
	}
}