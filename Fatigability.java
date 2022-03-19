class Solution {
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, dungeons.length, 0);
        return answer;
    }

    public void dfs(int[][] dungeons, boolean[] visited, int curFatigue, int length, int cnt) {
        answer = Math.max(cnt, answer);

        for(int i = 0; i < length; i++) {
            if(!visited[i] && curFatigue >= dungeons[i][0] && curFatigue >= dungeons[i][1]) {
                visited[i] = true;
                dfs(dungeons, visited, curFatigue - dungeons[i][1], length, cnt + 1);
                visited[i] = false;
            }
        }
    }
}