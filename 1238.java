import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Party {
    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = 100000001;

        int N, M, X;
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]);
        int[][] map = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int fr = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            map[fr][to] = cost;
        }

        int[] dist = dijkstra(N, X, map);

        for(int i = 1; i <= N; i++) {
            if(i == X) continue;
            int[] iToX = dijkstra(N, i, map);
            dist[i] += iToX[X];
        }

        int answer = 0;
        for(int d: dist) answer = Math.max(answer, d);
        System.out.println(answer);
    }

    public static int[] dijkstra(int N, int start, int[][] map) {
        int[] dist = new int[N + 1];
        for(int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for(int i = 1; i <= N; i++) {
                if(map[cur.v][i] != 0 && dist[i] > dist[cur.v] + map[cur.v][i]) {
                    dist[i] = dist[cur.v] + map[cur.v][i];
                    pq.add(new Node(i, dist[i]));
                }
            }
        }

        return dist;
    }
}
