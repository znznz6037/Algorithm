class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        for(int i = 0; i < puddles.length; i++)
            map[puddles[i][1]][puddles[i][0]] = -1; 
        map[1][1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] == -1) continue;
                if(i - 1 > 0 && map[i - 1][j] != -1) map[i][j] += map[i - 1][j] % 1000000007;
                if(j - 1 > 0 && map[i][j - 1] != -1) map[i][j] += map[i][j - 1] % 1000000007;
            }
        }
        return (map[n][m] % 1000000007);
    }
}

/*
효율성 테스트 시간 초과 ㅠㅠ
class Solution {
    static int y_limit = 0;
    static int x_limit = 0;
    static int min = Integer.MAX_VALUE;
    static int answer = 0;
    public int solution(int m, int n, int[][] puddles) {
        y_limit = n; x_limit = m;
        int[][] map = new int[n + 1][m + 1];
        for(int[] i : map) Arrays.fill(i, 10000);
        dfs(1, 1, 0, puddles, map);
        return (answer % 1000000007);
    }
    
    void dfs(int y, int x, int len, int[][] puddles, int[][] map){
        if(y == y_limit && x == x_limit){
            if(min == len) answer++;
            else if(min > len) {
                min = len;
                answer = 1;
            }
            return;
        }
        if(y > y_limit || x > x_limit) return;
        for(int i = 0; i < puddles.length; i++)
            if(y == puddles[i][1] && x == puddles[i][0]) return;
        if(map[y][x] >= len) {
            map[y][x] = len;
            if(x + 1 <= x_limit) dfs(y, x + 1, len + 1, puddles, map);
            if(y + 1 <= y_limit) dfs(y + 1, x, len + 1, puddles, map);
        }
    }
}
*/