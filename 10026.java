import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        br.close();

        System.out.println(numberOfRGBArea(false, map) + " " + numberOfRGBArea(true, map));
    }

    public static int numberOfRGBArea(boolean isRGBlindness, char[][] map) {
        int answer = 0;
        int N = map.length;
        boolean[][] visited = new boolean[N][N];

        for(int i = 0 ; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j]) continue;

                Stack<Pos> stack = new Stack<>();
                stack.add(new Pos(i, j));
                while (!stack.isEmpty()) {
                    Pos curPos = stack.pop();
                    visited[curPos.y][curPos.x] = true;

                    for (int k = 0; k < 4; k++) {
                        int ny = curPos.y + dir[k][0];
                        int nx = curPos.x + dir[k][1];
                        if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;

                        if (isRGBlindness) {
                            if (map[curPos.y][curPos.x] == 'B' && (map[ny][nx] == 'R' || map[ny][nx] == 'G')) continue;
                            if (map[curPos.y][curPos.x] != 'B' && map[ny][nx] == 'B') continue;
                        } else {
                            if (map[curPos.y][curPos.x] != map[ny][nx]) continue;
                        }

                        stack.push(new Pos(ny, nx));
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}