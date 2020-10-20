import java.io.*;

public class Main {
	static int n, m, target1, target2;
	static int[][] relation;
	static boolean[] visited;
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().split(" ");
			target1 = Integer.parseInt(s[0]);
			target2 = Integer.parseInt(s[1]);
			relation = new int[n + 1][n + 1];
			visited = new boolean[n + 1];
			m = Integer.parseInt(br.readLine());
			for(int i = 0; i < m; i++) {
				String[] str = br.readLine().split(" ");
				relation[Integer.parseInt(str[0])][Integer.parseInt(str[1])] =
						relation[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
			}
			br.close();
			
			System.out.println(DFS(target1, target2, 0));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int DFS(int start, int target, int num) {
		visited[start] = true;
		if(start == target) return num;
		int ans = -1;
		for(int i = 1; i <= n; i++) {
			if(relation[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				int sAns = DFS(i, target, num + 1);
				if(sAns != -1) ans = (ans != -1) ? Math.min(ans,  sAns) : sAns;
			}
		}
		return ans;
	}
}
/* 틀린 코드
 당장의 해말고 모든 조건을 비교해서 최솟값을 찾아야함.
import java.io.*;

public class Main {
	static int n, m, target1, target2;
	static int[][] relation;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().split(" ");
			target1 = Integer.parseInt(s[0]);
			target2 = Integer.parseInt(s[1]);
			relation = new int[n + 1][n + 1];
			visited = new boolean[n + 1];
			m = Integer.parseInt(br.readLine());
			for(int i = 0; i < m; i++) {
				String[] str = br.readLine().split(" ");
				relation[Integer.parseInt(str[0])][Integer.parseInt(str[1])] =
						relation[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
			}
			br.close();
			
			answer = 0;
			DFS(target1, target2, 1);
			System.out.println(answer);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void DFS(int start, int target, int num) {
		visited[start] = true;
		if(relation[start][target] == 1) {
			answer = num;
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(relation[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				DFS(i, target, num + 1);
				return;
			}
		}
		answer = - 1;
		return;
	}
}
 */
*/