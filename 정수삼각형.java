class Solution {
    static int max = 0;
    static int maxDepth = 0;
    public int solution(int[][] triangle) {
        maxDepth = triangle.length;
        int[][] memo = new int[triangle.length][triangle.length];
        for(int i = 0; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                memo[i][j] = -1;
            }
        }
        return dfs(0, 0, triangle, memo);
    }
    
    int dfs(int depth, int pos, int[][] arr, int memo[][]){
        if(depth >= maxDepth) return 0;
        return memo[depth][pos] = (memo[depth][pos] == -1) ? memo[depth][pos] = arr[depth][pos] + Math.max(dfs(depth + 1, pos, arr, memo), dfs(depth + 1, pos + 1, arr, memo)) : memo[depth][pos];
    }
}
/* 
DFS 시간 초과 : 삼각형의 높이를 n이라 할 때, 총 탐색은 O(2^n) 이 걸리므로 시간 초과

class Solution {
    static int max = 0;
    static int maxDepth = 0;
    public int solution(int[][] triangle) {
        maxDepth = triangle.length - 1;
        dfs(0, 0, 0, triangle);
        return max;
    }
    
    void dfs(int depth, int pos, int sum, int[][] arr){
        if(pos < 0) pos = 0;
        sum += arr[depth][pos];
        if(depth == maxDepth) {
            if(sum > max)
                max = sum;
            return;
        }
        dfs(depth + 1, pos, sum, arr);
        dfs(depth + 1, pos + 1, sum, arr);
    }
}
*/