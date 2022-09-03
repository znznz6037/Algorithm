import java.util.*;

class Solution {
    static boolean[][] adjacent;

    public int solution(int n, int[][] wires) {
        adjacent = new boolean[n + 1][n + 1];
        for(int i = 0; i < wires.length; i++) {
            adjacent[wires[i][0]][wires[i][1]] =
                    adjacent[wires[i][1]][wires[i][0]] = true;
        }

        return getOptimizedNetwork(n, wires);
    }

    public int getOptimizedNetwork(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < wires.length; i++) {
            adjacent[wires[i][0]][wires[i][1]] = adjacent[wires[i][1]][wires[i][0]] = false;
            int networkCnt = getNetworkCnt(n);
            adjacent[wires[i][0]][wires[i][1]] = adjacent[wires[i][1]][wires[i][0]] = true;

            answer = Math.min(answer, Math.abs(2 * networkCnt - n));
        }

        return answer;
    }

    public int getNetworkCnt(int n) {
        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                cnt++;
                queue.add(i);
                visited[i] = true;
                break;
            }
        }

        while(!queue.isEmpty()) {
            int next = queue.poll();
            for(int i = 1; i <= n; i++) {
                if(adjacent[next][i] && !visited[i]) {
                    queue.add(i);
                    cnt++;
                    visited[i] = true;
                }
            }
        }

        return cnt;
    }
}