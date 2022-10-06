import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class GetMinimumCost {
    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        int N, M;
        int[][] map;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(map[i], -1);
        }

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int fr = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            map[fr][to] = map[fr][to]!= -1 ? Math.min(map[fr][to], cost) : cost;
        }
        String[] input = br.readLine().split(" ");
        br.close();

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            visited[cur.v] = true;

            for(int i = 1; i <= N; i++) {
                if(map[cur.v][i] != -1 && !visited[i]) {
                    if(dist[i] > dist[cur.v] + map[cur.v][i]) {
                        dist[i] = dist[cur.v] +map[cur.v][i];
                        pq.add(new Node(i, dist[i]));
                    }
                }
            }
        }

        System.out.println(dist[end]);
    }
}
