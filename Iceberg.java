import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Iceberg {
    static int N, M;
    static int[][] map;

    static class Pos {
        int y, x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();

        int answer = 0;
        while(!melt()) {
            answer++;
            if(isDivided()) {
                System.out.println(answer);
                return;
            }
        }

        System.out.println(0);
    }

    public static boolean melt() {
        int total = 0;
        int[][] melted = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int cnt = 0;
                if(map[i][j] == 0) continue;
                if(i > 0 && map[i - 1][j] == 0) cnt++;
                if(i < N - 1 && map[i + 1][j] == 0) cnt++;
                if(j > 0 && map[i][j - 1] == 0) cnt++;
                if(j < M - 1 && map[i][j + 1] == 0) cnt++;
                melted[i][j] += cnt;
                total += cnt;
            }
        }

        if(total == 0) return true;

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] -= melted[i][j];
                if(map[i][j] < 0) map[i][j] = 0;
            }
        }

        return false;
    }

    public static boolean isDivided() {
        boolean[][] visited = new boolean[N][M];
        Queue<Pos> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0) {
                    q.add(new Pos(i, j));
                    visited[i][j] = true;
                    break;
                }
            }
            if(!q.isEmpty()) break;
        }

        int[][] dir = {
                {0, -1},
                {0, 1},
                {-1, 0},
                {1, 0}
        };

        while(!q.isEmpty()) {
            Pos curPos = q.poll();
            int y = curPos.y;
            int x = curPos.x;

            for(int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if(ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && map[ny][nx] > 0) {
                    visited[ny][nx] = true;
                    q.add(new Pos(ny, nx));
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0 && !visited[i][j]) return true;
            }
        }

        return false;
    }
}
