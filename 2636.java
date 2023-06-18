import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M, cnt;
    static int[][] map;
    static int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };

    static class Pos {
        int y;
        int x;

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
                if(map[i][j] != 0) cnt++;
            }
        }
        br.close();

        int times = 0, removeCnt = 0;

        while(cnt != 0) {
            times++;

            boolean[][] border = getBorderOfCheese();
            removeCnt = removeBorder(border);
            cnt -= removeCnt;
        }

        System.out.println(times + "\n" + removeCnt);
    }

    public static int removeBorder(boolean[][] border) {
        int removeCnt = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(border[i][j]) {
                    map[i][j] = 0;
                    removeCnt++;
                }
            }
        }

        return removeCnt;
    }

    public static boolean[][] getBorderOfCheese() {
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        boolean[][] border = new boolean[N][M];

        queue.add(new Pos(0, 0));

        while(!queue.isEmpty()) {
            Pos curPos = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = curPos.y + dir[i][0];
                int nx = curPos.x + dir[i][1];

                if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
                if(map[ny][nx] != 0) {
                    border[ny][nx] = true;
                    continue;
                }
                queue.add(new Pos(ny, nx));
                visited[ny][nx] = true;
            }
        }

        return border;
    }
}