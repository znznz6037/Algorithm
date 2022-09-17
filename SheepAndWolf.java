import java.util.*;

class Solution {
    boolean[][] adj;
    int maxSheep;

    public int solution(int[] info, int[][] edges) {
        adj = new boolean[info.length][info.length];
        maxSheep = 0;

        for(int i = 0; i < edges.length; i++) {
            adj[edges[i][0]][edges[i][1]] = true;
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);

        dfs(0, info, list, 0, 0);

        return maxSheep;
    }

    public void dfs(int cur, int[] info, List<Integer> list, int sheep, int wolf) {
        sheep += info[cur] ^ 1;
        wolf += info[cur];

        maxSheep = Math.max(maxSheep, sheep);

        if(wolf >= sheep) return;

        List<Integer> copyList = new ArrayList<>();
        copyList.addAll(list);

        for(int i = 0; i < info.length; i++) {
            if(adj[cur][i]) copyList.add(i);
        }
        copyList.remove(Integer.valueOf(cur));

        for(int next: copyList) dfs(next, info, copyList, sheep, wolf);
    }
}