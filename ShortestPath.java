import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPath {
    static int V, E, K;
    static List<List<Node>> graph;

    static class Node {
        int v;
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strArr[] = br.readLine().split(" ");
        V = Integer.parseInt(strArr[0]);
        E = Integer.parseInt(strArr[1]);

        String str = br.readLine();
        K = Integer.parseInt(str);

        graph = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            strArr = br.readLine().split(" ");
            graph.get(Integer.parseInt(strArr[0])).add(new Node(Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])));
        }

        br.close();

        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];
        for(int i = 1; i <= V; i++) dist[i] = Integer.MAX_VALUE;
        dist[K] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        priorityQueue.add(new Node(K, 0));
        while(!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.poll();
            visited[curNode.v] = true;

            for(Node nextNode: graph.get(curNode.v)) {
                if(!visited[nextNode.v] && dist[nextNode.v] > curNode.cost + nextNode.cost) {
                    dist[nextNode.v] = curNode.cost + nextNode.cost;
                    priorityQueue.add(new Node(nextNode.v, dist[nextNode.v]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }
}
