import java.util.*;

class Solution {
    int[][] dir = {
        {0, 1},
        {0, -1},
        {-1, 0},
        {1, 0}
    };
    int[][] map;
    int width, length;
    boolean[][] visited;
    
    public int[] solution(String[] maps) {
        length = maps.length;
        width = maps[0].length();
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                char c = maps[i].charAt(j);
                if(c == 'X') map[i][j] = 0;
                else map[i][j] = c - '0';
            }
        }
        
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                if(map[i][j] != 0 && !visited[i][j]) answer.add(dfs(i, j, 0));
            }
        }
        
        int len = answer.size();
        if(len == 0) return new int[]{-1};
        
        int[] answerArr = new int[len];
        for(int i = 0; i < len; i++) {
            answerArr[i] = answer.get(i);
        }
        Arrays.sort(answerArr);
        
        return answerArr;
    }
    
    public int dfs(int y, int x, int cnt) {
        cnt += map[y][x];
        visited[y][x] = true;
        
        int ny, nx;
        for(int i = 0; i < dir.length; i++) {
            ny = y + dir[i][0];
            nx = x + dir[i][1];
    
            if(!isValid(ny, nx) || visited[ny][nx] || map[ny][nx] == 0) continue;
            cnt = dfs(ny, nx, cnt);
        }
        
        return cnt;
    }
    
    public boolean isValid(int y, int x) {
        if(y < 0 || x < 0 || y >= length || x >= width) return false;
        return true;
    }
}
