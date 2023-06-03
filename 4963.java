import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {-1, 1},
            {1, 1},
            {1, -1},
            {-1, -1}
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

        while(true) {
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            if(w == 0 && h == 0) {
                br.close();
                break;
            }

            int[][] map = new int[h][w];

            for(int i = 0; i < h; i++) {
                input = br.readLine().split(" ");
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            int answer = 0;
            boolean[][] visited = new boolean[h][w];
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        getCountOfIsland(map, visited, i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void getCountOfIsland(int[][] map, boolean[][] visited, int y, int x) {
        Stack<Pos> stack = new Stack<>();
        stack.add(new Pos(y, x));

        int h = map.length;
        int w = map[0].length;

        while(!stack.isEmpty()) {
            Pos coord = stack.pop();
            visited[coord.y][coord.x] = true;

            for(int i = 0; i < 8; i++) {
                int ny = coord.y + dir[i][0];
                int nx = coord.x + dir[i][1];
                if(ny < 0 || ny >= h || nx < 0 || nx >= w || visited[ny][nx] || map[ny][nx] == 0) continue;

                stack.add(new Pos(ny, nx));
            }
        }
    }
}