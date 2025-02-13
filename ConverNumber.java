import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        
        boolean[] visited = new boolean[3000001];
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
                       
            int num = cur[0];
            int count = cur[1];
            
            if(num == y) return count;
            
            int idx = 0;
            while(idx++ < 3) {
                int temp;
                if(idx == 1) temp = num * 3;
                else if(idx == 2) temp = num * 2;
                else temp = num + n;
                
                if(!visited[temp] && temp <= y) {
                    queue.add(new int[]{temp, count + 1});
                    visited[temp] = true;    
                }
            }
        }
        
        return -1;
    }
}
