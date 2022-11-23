import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 100000000;
    static int N;
    static int E;
    static int v1;
    static int v2;
    static List<List<Node>> graph ;

    private static class Node {
        int v;
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        graph = new ArrayList<>();
        int[] dist1;
        int[] distV1;
        int[] distN;

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            graph.get(Integer.parseInt(input[0])).add(new Node(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
            graph.get(Integer.parseInt(input[1])).add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[2])));
        }

        input = br.readLine().split(" ");
        v1 = Integer.parseInt(input[0]);
        v2 = Integer.parseInt(input[1]);

        br.close();

        dist1 = dijkstra(1);
        distV1 = dijkstra(v1);
        distN = dijkstra(N);

        int answer = Math.min(dist1[v1] + distV1[v2] + distN[v2], dist1[v2] + distV1[v2] + distN[v1]);
        System.out.println(answer >= INF ? -1 : answer);
    }

    public static int[] dijkstra(int start) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));

        int[] dist = new int[N + 1];
        for(int i = 0; i <= N; i++) dist[i] = INF;
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.v] = true;

            List<Node> list = graph.get(node.v);
            for(Node next: list) {
                if(!visited[next.v] && dist[next.v] > node.cost + next.cost) {
                    dist[next.v] = node.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }
}
