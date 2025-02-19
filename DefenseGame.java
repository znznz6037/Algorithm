import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(k >= enemy.length) return enemy.length;                
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.offer(enemy[i]);                       
            
            if(n < 0) {
                if(k == 0) return i;
                n += pq.poll();
                k--;
            }
        }        
        
        return enemy.length;
    }
}
