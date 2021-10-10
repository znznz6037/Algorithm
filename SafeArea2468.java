import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class SafeArea2468 {
    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N = 0;
    static int maxArea = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            map = new int[N][N];

            ArrayList<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                str = br.readLine().split(" ");
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                    if(!levelList.contains(map[i][j])) levelList.add(map[i][j]);
                }
            }
            br.close();

            for(int level: levelList) {
                int area = 0;
                visited = new boolean[N][N];
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < N; k++) {
                        if(map[j][k] > level && !visited[j][k]) {
                            DFS(j, k, level);
                            area++;
                        }
                    }
                    maxArea = Math.max(area, maxArea);
                }
            }

            System.out.print(maxArea);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void DFS(int y, int x, int level) {
        Stack<Pos> stack = new Stack<>();
        stack.add(new Pos(y, x));
        visited[y][x] = true;

        while(!stack.isEmpty()) {
            Pos pos = stack.pop();
            int curY = pos.y;
            int curX = pos.x;

            for(int i = 0; i < 4; i++) {
                int nextY = curY + dir[i][0];
                int nextX = curX + dir[i][1];
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < N && map[nextY][nextX] > level && !visited[nextY][nextX]) {
                    stack.push(new Pos(nextY, nextX));
                    visited[nextY][nextX] = true;
                }
            }
        }
    }
}
