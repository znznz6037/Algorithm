import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] adj = new int[n][n];
        for(int i = 0; i < costs.length; i ++) adj[costs[i][0]] [costs[i][1]] = adj[costs[i][1]][costs[i][0]] = costs[i][2];
        
        ArrayList<Integer> bridge = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        bridge.add(0);
        while(bridge.size() < n) {
            int min = Integer.MAX_VALUE;
            int minIdx = 0;
            for(int i = 0; i < bridge.size(); i++){
                int island = bridge.get(i);
                for(int j = 0; j < n; j++){
                    if(island != j && !visited[j] && adj[island][j] > 0 && min > adj[island][j]){
                        min = adj[island][j];
                        minIdx = j;
                    }
                }
            }
            visited[minIdx] = true;
            bridge.add(minIdx);
            answer += min;
        }
        return answer;
    }
}