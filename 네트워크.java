import java.util.*;

class Solution {
    int vertex[] = new int[201];
    static int cnt = 0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer>q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(vertex[i] == 0) {
                cnt++;
                vertex[i] = 1;
                q.add(i);
            }
            while(!q.isEmpty()){
                int v = q.poll();
                for(int j = 0; j < n; j ++){
                    if(computers[v][j] != 0 && j != v){
                        if(vertex[j] == 0){
                            vertex[j] = 1;
                            q.add(j);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}