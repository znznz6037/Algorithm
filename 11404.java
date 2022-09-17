import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Floyd {
    static int N, M;
    static int[][] dist;
    static final int INF = 99999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            dist[a][b] = dist[a][b] !=  0 ? Math.min(dist[a][b], c) : c;
        }
        br.close();

        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) continue;
                else if(dist[i][j] == 0) dist[i][j] = INF;
            }
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(dist[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
