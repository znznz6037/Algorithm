import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (o1, o2) -> {
           if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int std = targets[0][1];
        for(int i = 0; i < targets.length; i++) {
            if(targets[i][0] >= std) {
                answer++;
                std = targets[i][1];
            }
        }
        
        return answer;
    }
}
