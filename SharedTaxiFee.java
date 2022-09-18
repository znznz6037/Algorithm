class Solution {
    int[][] dist;
    final int INF = 99999999;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        dist = new int[n + 1][n + 1];

        for(int[] fare: fares) {
            dist[fare[0]][fare[1]] = dist[fare[1]][fare[0]] = fare[2];
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) dist[i][j] = 0;
                else if(dist[i][j] == 0) dist[i][j] = INF;
            }
        }

        floydWashall(n);

        answer = dist[s][a] + dist[s][b];

        for(int i = 1; i <= n; i++) {
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }

        return answer;
    }

    public void floydWashall(int n) {
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == j) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}