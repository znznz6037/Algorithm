import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                dp[i][j] = -1;
            }
        }
        br.close();

        System.out.println(DFS(0, 0));
    }

    public static int DFS(int y, int x) {
        if(y == M - 1 && x == N - 1) return 1;
        if(dp[y][x] != -1) return dp[y][x];

        dp[y][x] = 0;
        for(int i = 0; i < 4; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];
            if(ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
            if(map[ny][nx] >= map[y][x]) continue;

            dp[y][x] += DFS(ny, nx);
        }

        return dp[y][x];
    }
}
