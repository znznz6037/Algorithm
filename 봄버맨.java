import java.util.*;

class Grid {
	int y;
	int x;
	char grid;
	int second;
	
	public Grid(int y, int x, char grid, int second) {
		this.y = y;
		this.x = x;
		this.grid = grid;
		this.second = second;
	}
}

public class Main {
	static int R, C, N;
	static Grid[][] map;
	static int dir[][] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		N = sc.nextInt() - 1;
		map = new Grid[R][C];
		for(int i = 0; i < R; i++) {
			String str = sc.next();
			for(int j = 0; j < C; j++) {
				char grid = str.charAt(j);
				map[i][j] = new Grid(i, j, grid, 2);
			}
		}
		sc.close();
		
		while(N > 0) process();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(map[i][j].grid);
			}
			System.out.println();
		}
	}
	
	static void time() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j].second += 2;
			}
		}
		N -= 2;
	}
	//폭탄 설치
	static void process() {
		//폭탄 설치. 폭탄 있으면 초 증가시키기
		for(int i = 0; i < R; i++) 
			for(int j = 0; j < C; j++) 
				if(map[i][j].grid == '.') map[i][j] = new Grid(i, j, 'O', 0);
		
		
		time();
		if(N < 0) return;
		
		//설치한 지 3초된 폭탄 폭발시키기
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j].grid == 'O' && map[i][j].second >= 3) BFS(i, j);
			}
		}
	}
	
	static void BFS(int Y, int X) {
		Queue<Grid> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		q.add(map[Y][X]);
		visited[Y][X] = true;
		while(!q.isEmpty()) {
			int y = q.peek().y;
			int x = q.peek().x;
			map[y][x].grid = '.';
			q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = y + dir[i][0], nx = x + dir[i][1];
				if(ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx]) continue;
				if(map[ny][nx].grid == 'O' && map[ny][nx].second >= 3) 
					q.add(map[ny][nx]);
				visited[ny][nx] = true;
				map[ny][nx].grid = '.';
			}
			
		}
	}
	
}