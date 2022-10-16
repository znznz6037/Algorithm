import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        long sum = 0;
        int max = 0;

        for(int work: works) {
            if(work > max) max = work;
            sum += work;
        }
        if(sum < n) return 0;

        while(n > 0) {
            for(int i = works.length - 1; i >= 0 && n > 0; i--) {
                if(max == works[i]) {
                    works[i]--;
                    n--;
                }
            }
            max--;
        }

        for(int work: works) answer += Math.pow(work, 2);
        return answer;
    }
}