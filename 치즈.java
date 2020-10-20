import java.io.*;
import java.util.*;

class Coord implements Comparable<Coord>{
	public int y;
	public int x;
	
	public Coord(int y, int x) {
		this.y = y;
		this.x = x;
	}

	@Override
	public int compareTo(Coord arg0) {
		// TODO Auto-generated method stub
		if(this.y > arg0.y) return 1;
		else if(this.y < arg0.y) return -1;
		else {
			if(this.x > arg0.x) return 1;
			else if(this.x < arg0.x) return -1;
			return 0;
		}
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s[] = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			map = new int[N][M];
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			br.close();
			
			int answer = 0;
			while(!searchBorder(0, 0)) answer++;
			System.out.println(answer);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean searchBorder(int Y, int X) {
		//BFS로 빈 공간만 탐색
		boolean[][] visited = new boolean[N][M];
		ArrayList<Coord> border = new ArrayList<>();
		Queue<Coord> q = new LinkedList<>();
		q.add(new Coord(Y, X));
		visited[Y][X] = true;
		while(!q.isEmpty()) {
			int y = q.peek().y, x = q.peek().x;
			q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = y + dir[i][0], nx = x + dir[i][1];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
				if(map[ny][nx] == 1) {
					border.add(new Coord(ny, nx));
					continue;
				}
				visited[ny][nx] = true;
				q.add(new Coord(ny, nx));
			}
		}
		//빈 공간 탐색 후 치즈 경계선 리스트인 border 내 중복값이 있다면 두면 이상 접촉된 것이므로 치즈 제거
		Collections.sort(border);
		int cnt = 0;
		for(int i = 0; i < border.size() - 1; i++) {
			int y = border.get(i).y, x = border.get(i).x;
			for(int j = i + 1; j < border.size(); j++) {
				if(border.get(j).y == y && border.get(j).x == x) {
					//System.out.println("(" + y + ", " + x + ")");
					map[y][x] = 0;
					break;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) cnt++;
			}
		}
		
		return cnt == N * M;
	}
}