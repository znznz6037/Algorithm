import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        for(int i = 0; i < cards.length; i++) {
            boolean[] visited = new boolean[cards.length];
            
            int score1 = getPoint(i, cards, visited);
            if(score1 == 0) continue;
            
            for(int j = 0; j < cards.length; j++) {
                if(!visited[j]) {
                    int score2 = getPoint(j, cards, visited);
                    answer = Math.max(answer, score1 * score2);
                }
            }
        }
        
        return answer;
    }
    
    public int getPoint(int i, int[] cards, boolean[] visited) {
        int cnt = 0;
        int point = 0;
        
        while(!visited[cards[i] - 1]) {
            visited[cards[i] - 1] = true;
            i = cards[i] - 1;
            cnt++;
        }
        
        if(cnt == cards.length) return 0;
        return cnt;
    }
}
