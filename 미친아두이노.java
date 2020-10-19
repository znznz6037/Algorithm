// 입출력할때 Scanner 쓰지 말고 BufferedReader, BufferedWriter 쓰기!!! Scanner 쓰면 시간초과남!!!
import java.io.*;
import java.util.*;

class Grid {
	int y;
	int x;
	char grid;
	
	public Grid(int y, int x, char grid) {
		this.y = y;
		this.x = x;
		this.grid = grid;
	}
}

public class Main {
	
	static int R, C;
	static Grid map[][];
	static int jongsu[];
	static ArrayList<Grid> arduino = new ArrayList<>();
	static int dir[][] = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 0}, 
			{0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
	static int curY, curX;
	static int n;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			String s[] = br.readLine().split(" ");
			R = Integer.parseInt(s[0]);
			C = Integer.parseInt(s[1]);
			map = new Grid[R][C];
			for(int i = 0; i < R; i++) {
				String str = br.readLine();
				for(int j = 0; j < C; j++) {
					map[i][j] = new Grid(i, j, str.charAt(j));
					if(str.charAt(j) == 'I') {
						curY = i; curX= j;
					}
					else if(str.charAt(j) == 'R') arduino.add(new Grid(i, j, 'R'));
				}
			}
			String str = br.readLine();
			br.close();
			jongsu = new int[str.length()];
			for(int i = 0; i < str.length(); i++) jongsu[i] = str.charAt(i) - '0';
			
			n = 0;
			while(n < jongsu.length) {
				if(!moveJongsu(curY, curX, jongsu[n] - 1)) return;
				if(!moveArduino()) return;
				n++;
			}
			
			//정답 출력
			ArrayList<String> arr = new ArrayList<>();
			for(int i = 0; i < R; i++) {
				String string = "";
				for(int j = 0; j < C; j++) {
					string += map[i][j].grid;
				}
				arr.add(string);
			}
		
			 for(int i = 0; i < arr.size(); i++) {
	                bw.write(arr.get(i));
	                bw.newLine();
            }
            bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//1, 2번 조건
	static boolean moveJongsu(int y, int x, int direction) { 
		map[y][x].grid = '.';
		if(map[y + dir[direction][0]][x + dir[direction][1]].grid == 'R') {
			System.out.println("kraj " + (n + 1));
			return false;
		}
		map[y + dir[direction][0]][x + dir[direction][1]].grid = 'I';
		curY = y + dir[direction][0];
		curX = x + dir[direction][1];
		return true;
	}
	
	//3, 4, 5번 조건
	static boolean moveArduino() {
		//3, 4번 조건
		ArrayList<Grid> tmp = new ArrayList<>();
		for(int i = 0; i < arduino.size(); i++) {
			int min = Integer.MAX_VALUE, idx = -1;
			int y = arduino.get(i).y, x = arduino.get(i).x;
			for(int j = 0; j < 9; j++) {
				if(j == 4) continue; // 제 자리 방향 건너뛰기
				int ny = y + dir[j][0], nx = x + dir[j][1];
				if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				int distance = Math.abs(curY - ny) + Math.abs(curX - nx);
				if(min >= distance) {
					min = distance;
					idx = j;
				}
			}
			map[y][x].grid = '.';
			if(map[y + dir[idx][0]][x + dir[idx][1]].grid == 'I') {
				System.out.println("kraj " + (n + 1));
				return false;
			}
			int ny = arduino.get(i).y + dir[idx][0];
			int nx = arduino.get(i).x + dir[idx][1];
			tmp.add(new Grid(ny, nx, 'R'));
		}
		
		//5번 조건		
		arduino.clear();
		for(int i = 0; i < tmp.size() - 1; i++) {
			for(int j = i + 1; j < tmp.size(); j++) {
				if(tmp.get(i).y == tmp.get(j).y && tmp.get(i).x == tmp.get(j).x) {
					tmp.set(i, new Grid(tmp.get(i).y, tmp.get(i).x, '.'));
					tmp.set(j, new Grid(tmp.get(i).y, tmp.get(i).x, '.'));
				}
			}
		}
		
		for(int i = 0; i < tmp.size(); i++) {
			if(tmp.get(i).grid == 'R') {	
				map[tmp.get(i).y][tmp.get(i).x].grid = 'R';
				arduino.add(tmp.get(i)); 
			}
		}
		return true;
	}
	
}