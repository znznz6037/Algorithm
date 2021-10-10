import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato7576 {
    private static class Pos {
        int x;
        int y;
        int day;

        public Pos(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }

    static int answer = 0;
    static int N;
    static int M;
    static int[][] map;
    static int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    static boolean[][] visited;
    static Queue<Pos> rottenTomatoList = new LinkedList<>();

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);
            map = new int[M][N];
            visited = new boolean[M][N];
            boolean isRottenAll = true;
            boolean isNoRottenTomato = true;

            for(int i = 0; i < M; i++) {
                str = br.readLine().split(" ");
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                    if(map[i][j] == 1) {
                        rottenTomatoList.add(new Pos(i, j, 0));
                        isNoRottenTomato = false;
                    }
                    if(map[i][j] == 0) isRottenAll = false;
                }
            }

            if(isRottenAll) {
                System.out.print(answer);
                return;
            }

            if (isNoRottenTomato) {
                answer = -1;
                System.out.print(answer);
                return;
            }

            BFS();

            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 0) {
                        answer = -1;
                        System.out.print(answer);
                        return;
                    }
                }
            }
            System.out.print(answer);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void BFS() {
        while(!rottenTomatoList.isEmpty()) {
            Pos pos = rottenTomatoList.poll();
            int curY = pos.y;
            int curX = pos.x;
            int curDay = pos.day;
            answer = Math.max(curDay , answer);

            for (int i = 0; i < 4; i++) {
                int nextY = curY + dir[i][0];
                int nextX = curX + dir[i][1];
                if(nextY >= 0 && nextY < M && nextX >= 0 && nextX < N && !visited[nextY][nextX] && map[nextY][nextX] == 0) {
                    rottenTomatoList.add(new Pos(nextY, nextX, curDay + 1));
                    visited[nextY][nextX] = true;
                    map[nextY][nextX] = 1;
                }
            }
        }
    }
}
