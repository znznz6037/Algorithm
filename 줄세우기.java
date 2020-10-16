import java.util.*;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int[] edgeCnt = new int[N + 1]; //간선 수 배열
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //
		
		for(int i = 0; i <= N; i++)
			graph.add(new ArrayList<Integer>());
				
		for(int i = 0; i < M; i++) { // 그래프 연결
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph.get(v1).add(v2);
			edgeCnt[v2]++; // 도착 정점의 간선으로 추가
		}
		sc.close();
		
		topologicalSort(graph, edgeCnt);
	}
	
	static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] edgeCnt) {
		Queue<Integer> queue = new LinkedList<>();
		
		//선행 정점이 없는 모든 정점을 큐에 삽입
		for(int i = 1; i <= N; i++) {
			if(edgeCnt[i] == 0) queue.add(i);
		}
		
		for(int i = 0; i < N; i++) {
			int v = queue.poll(); //큐에서 정점 삭제
			System.out.print(v + " ");
			
			for(int nextV : graph.get(v)) {  // 해당 정점과 연결된 모든 정점에 대해
				edgeCnt[nextV]--; //간선 수 감소
				if(edgeCnt[nextV] == 0) queue.add(nextV); //해당 정점의 간선이 0이면 큐에 삽입
			}
		}
	}
}