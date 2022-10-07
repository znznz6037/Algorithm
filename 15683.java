import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Watch {
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[][] office;
    static List<Pos> cctvList;
    static int[][][] cctvDir = {
            {{}},
            {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}},
            {{1, 1, 0, 0}, {0, 0, 1, 1}},
            {{1, 0, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 1}},
            {{1, 1, 1, 0}, {1, 0, 1, 1}, {1, 1, 0 , 1}, {0, 1, 1, 1}},
            {{1, 1, 1, 1}}
    };

    static int[][] dir = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    static class Pos {
        int y;
        int x;
        int type;

        Pos(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        office = new int[N][M];
        cctvList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(input[j]);
                if(office[i][j] != 0 && office[i][j] != 6) {
                    cctvList.add(new Pos(i, j, office[i][j]));
                }
            }
        }

        dfs(0, office);
        System.out.println(answer);
    }

    public static void check(int y, int x, int[] rotate, int[][] map) {
        for(int i = 0; i < 4; i++) {
            if(rotate[i] != 0) {
                int ry = y;
                int rx = x;
                while(true) {
                    ry += dir[i][0];
                    rx += dir[i][1];
                    if(ry < 0 || ry >= N || rx < 0 || rx >= M) break;
                    if(map[ry][rx] == 6) break;
                    map[ry][rx] = -1;
                }
            }
        }
    }

    public static void recover(int[][] recover, int[][] map) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = recover[i][j];
            }
        }
    }

    public static void dfs(int step, int[][] map) {
        if(step == cctvList.size()) {
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 0) cnt++;
                }
            }

            answer = Math.min(answer, cnt);
            return;
        }

        final int[][] copy = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }

        Pos pos = cctvList.get(step);
        switch(pos.type) {
            case 1:
                for(int i = 0; i < 4; i++) {
                    check(pos.y, pos.x, cctvDir[1][i], map);
                    dfs(step + 1, map);
                    //map = copy;
                    recover(copy, map);
                }
                break;

            case 2:
                for(int i = 0; i < 2; i++) {
                    check(pos.y, pos.x, cctvDir[2][i], map);
                    dfs(step + 1, map);
                    recover(copy, map);
                }
                break;

            case 3:
                for(int i = 0; i < 4; i++) {
                    check(pos.y, pos.x, cctvDir[3][i], map);
                    dfs(step + 1, map);
                    recover(copy, map);
                }
                break;

            case 4:
                for(int i = 0; i < 4; i++) {
                    check(pos.y, pos.x, cctvDir[4][i], map);
                    dfs(step + 1, map);
                    recover(copy, map);
                }
                break;

            case 5:
                check(pos.y, pos.x, cctvDir[5][0], map);
                dfs(step + 1, map);
                recover(copy, map);
                break;
        }
    }
}
