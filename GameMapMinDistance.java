import java.util.*;

class Solution {
    int n;
    int m;

    class Coord {
        int y;
        int x;
        int len;

        Coord(int y, int x, int len) {
            this.y = y;
            this.x = x;
            this.len = len;
        }
    }

    public int solution(int[][] maps) {
        int answer = -1;
        int[][] dir = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        n = maps.length;
        m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<Coord> queue = new LinkedList<Coord>();
        queue.add(new Coord(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Coord coord = queue.poll();
            int y = coord.y;
            int x = coord.x;
            int len = coord.len;

            if(y == n - 1 && x == m - 1) return len;
            for(int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if(!isExceed(ny, nx) && !visited[ny][nx] && maps[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.add(new Coord(ny, nx, len + 1));
                }
            }
        }

        return answer;
    }

    public boolean isExceed(int y, int x) {
        if(y < 0 || y >= n || x < 0 || x >= m) return true;
        return false;
    }
}