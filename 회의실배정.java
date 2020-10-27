import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting>{
	public int start;
	public int end;
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	// 벙위를 this.end - arg0.end 로만 설정해서 틀렸음. 모든 경우의 수를 고려해서 정렬할 것.
	@Override
	public int compareTo(Meeting arg0) {
		// TODO Auto-generated method stub
		if(this.end > arg0.end) return 1;
		else if(this.end == arg0.end) {
			return this.start - arg0.end;
		}
		return -1;
	}
}

public class Main {
	static int N;
	static ArrayList<Meeting> room;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			room = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				room.add(new Meeting(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
			}
			br.close();
			
			Collections.sort(room);
			int start = 0, end = 0, cnt = 0;
			for(int i = 0; i < room.size(); i++) {
				if(room.get(i).start >= end) {
					cnt++;
					end = room.get(i).end;
				}
			}
			System.out.println(cnt);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
