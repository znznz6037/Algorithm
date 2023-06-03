import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    static int[][] map;
    static int N, M;

    static class Pos {
        int y;
        int x;
        int cnt;
        boolean crushed;

        Pos(int y, int x, int cnt, boolean crushed) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.crushed = crushed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        search();
    }

    public static void search() {
        boolean[][][] visited = new boolean[N][M][2];
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, 1, false));

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            if(pos.y == N - 1 && pos.x == M - 1) {
                System.out.println(pos.cnt);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int ny = pos.y + dir[i][0];
                int nx = pos.x + dir[i][1];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                if(map[ny][nx] == 1) {
                    if(pos.crushed) continue;
                    queue.add(new Pos(ny, nx, pos.cnt + 1, true));
                    visited[ny][nx][1] = true;
                }
                else {
                    if(pos.crushed && !visited[ny][nx][1]) {
                        queue.add(new Pos(ny, nx, pos.cnt + 1, true));
                        visited[ny][nx][1] = true;
                    }
                    else if(!pos.crushed && !visited[ny][nx][0]) {
                        queue.add(new Pos(ny, nx, pos.cnt + 1, false));
                        visited[ny][nx][0] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}