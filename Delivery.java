import java.util.*;

class Solution {
    int N;
    int K;
    int answer = 1;
    int[][] adj;
    int[] minDist;

    public int solution(int N, int[][] road, int K) {
        minDist = new int[N + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        this.N = N;
        this.K = K;

        //인접 행렬
        adj = new int[N + 1][N + 1];
        for(int i = 0; i < road.length; i++) {
            if(adj[road[i][0]][road[i][1]] == 0 || adj[road[i][0]][road[i][1]] > road[i][2]) {
                adj[road[i][0]][road[i][1]] = adj[road[i][1]][road[i][0]] = road[i][2];
            }
        }

        //다익스트라
        canDeliveryInK(1, 0);

        return answer;
    }

    public void canDeliveryInK(int cur, int dist) {
        minDist[cur] = dist;

        for(int i = 1; i <= N; i++) {
            if(adj[cur][i] == 0 || adj[cur][i] + dist > K || adj[cur][i] + dist > minDist[i]) continue;
            if(minDist[i] == Integer.MAX_VALUE) answer++;
            canDeliveryInK(i, dist + adj[cur][i]);
        }
    }
}