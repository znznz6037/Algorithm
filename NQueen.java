class Solution {
    public int solution(int n) {
        int[] visited = new int[n];
        return DFS(n, visited, 0);
    }

    public int DFS(int n, int[] visited, int level) {
        int answer = 0;

        if(level == n) {
            return 1;
        }

        for(int i = 0; i < n; i++) {
            if(isPossible(visited, level, i)) {
                visited[level] = i;
                answer += DFS(n, visited, level + 1);
            }
        }

        return answer;
    }

    public boolean isPossible(int[] visited, int level, int x) {
        for(int i = 0; i < level; i++) {
            if(visited[i] == x || Math.abs(i - level) == Math.abs(visited[i] - x)) return false;
        }

        return true;
    }
}