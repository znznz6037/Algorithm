import java.io.*;
import java.util.*;

class Pos {
	public int z;
	public int y;
	public int x;
	public int date;
	
	public Pos(int z, int y, int x, int date) {
		this.z = z;
		this.y = y;
		this.x = x;
		this.date = date;
	}
}

public class Main {
	static int M, N, H, answer, cnt;
	static int[][][] tomatoes;
	static int[][] dir = {{0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};
	static boolean[][][] visited;
	static Queue<Pos> q;
	
	public static void main(String[] args) {
		try {
			answer = 0;
			q = new LinkedList<>();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] str = br.readLine().split(" ");
			M = Integer.parseInt(str[0]);
			N = Integer.parseInt(str[1]);
			H = Integer.parseInt(str[2]);
			tomatoes = new int[H][N][M];
			visited = new boolean[H][N][M];
			boolean flag = true;
			cnt = 0;
			for(int k = 0; k < H; k++) {
				for(int i = 0; i < N; i++) {
					str = br.readLine().split(" ");
					for(int j = 0; j < M; j++) { // H N M
						tomatoes[k][i][j] = Integer.parseInt((str[j]));
						if(tomatoes[k][i][j] == 0) {
							flag = false;
							cnt++;
						}
						else if(tomatoes[k][i][j] == 1) q.add(new Pos(k, i, j, 0));
					}
				}
			}
			br.close();
			
			if(q.isEmpty()) {
				System.out.println(-1);
				return;
			}
			else if(flag) {
				System.out.println(0);
				return;
			}
			
			BFS();
			
			if(cnt != 0) {
				System.out.println(-1);
				return;
			}
			System.out.println(answer);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static void BFS() {
		int maxDate = 0;
		while(!q.isEmpty()) {
			int z = q.peek().z, y = q.peek().y, x = q.peek().x, date = q.peek().date;
			visited[z][y][x] = true;
			maxDate = Math.max(date, maxDate);
			q.poll();
			for(int i = 0; i < 6; i++) {
				int nz = z + dir[i][0], ny = y + dir[i][1], nx = x + dir[i][2];
				if(nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M
						|| visited[nz][ny][nx] || tomatoes[nz][ny][nx] == -1) continue;
				if(tomatoes[nz][ny][nx] == 0) {
					cnt--;
					tomatoes[nz][ny][nx] = 1;
				}
				visited[nz][ny][nx] = true;
				q.add(new Pos(nz, ny, nx, date + 1));
			}
		}
		answer = Math.max(answer, maxDate);
	}
}
