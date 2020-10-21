import java.io.*;
import java.util.*;

class Teacher {
	public int y;
	public int x;
	
	public Teacher(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int N;
	static char map[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean answer;
	static ArrayList<Teacher> teacher;
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			teacher = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = str[j].charAt(0);
					if(map[i][j] == 'T') teacher.add(new Teacher(i, j));
				}
			}
			br.close();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == N - 1 && j == N - 2) break;
					if(map[i][j] == 'X') {
						map[i][j] = 'O';
						if(DFS(i, j, 1)) {
							System.out.println("YES");
							return;
						}
						map[i][j] = 'X';
					}
				}
			}
			System.out.println("NO");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static boolean DFS(int prevY, int prevX, int cnt) {
		if(cnt == 3) return answer = search();
		
		int y = prevX >= N ? prevY + 1 : prevY;
		int x = prevX >= N ? 0 : prevX + 1;
		for(; y < N; y++) {
			x = x >= N ? 0 : x;
			for(; x < N; x++) {
				if(map[y][x] != 'X') continue;
				map[y][x] = 'O';
				if(DFS(y, x, cnt + 1)) return true;
				map[y][x] = 'X';
			}
		}
		return false;
	}
	
	static boolean search() {
		for(int i = 0; i < teacher.size(); i++) {
			int y = teacher.get(i).y, x = teacher.get(i).x;
			for(int j = 0; j < 4; j++) {
				int ny = y, nx = x;
				while(true) {
					ny += dir[j][0]; nx += dir[j][1];
					if(ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == 'O') break;
					if(map[ny][nx] == 'S') return false;
				}
			}
		}
		return true;
	}
}