import java.util.*;

class Solution {
    private int width;
    private int length;
    
    private class Pos {
        int y;
        int x;
        int cnt;
        
        Pos(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    
    public int solution(String[] board) {
        int y = 0, x = 0;
        width = board[0].length();
        length = board.length;
        int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        
        char[][] map = new char[length][width];
        for(int i = 0; i < length; i++) {            
            for(int j = 0; j < width; j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R') {
                    map[i][j] = '.';
                    y = i;
                    x = j;
                }
            }
        }
        
        boolean[][] visited = new boolean[length][width];
        visited[y][x] = true;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(y, x, 0));
        
        //BFS
        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            if(map[pos.y][pos.x] == 'G') {
                return pos.cnt;
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = pos.y;
                int nx = pos.x;
                
                while(true) {                    
                    ny += dir[i][0];
                    nx += dir[i][1];
                    if(!isValid(ny, nx) || map[ny][nx] == 'D') break;
                }
                
                ny -= dir[i][0];
                nx -= dir[i][1];
                if(!isValid(ny, nx)) continue;
                if((pos.y == ny && pos.x == nx) || visited[ny][nx]) continue;
                queue.add(new Pos(ny, nx, pos.cnt + 1));
                visited[ny][nx] = true;
            }
        }
        
        return -1;
    }
    
    public boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < length && x < width;
    }
}
