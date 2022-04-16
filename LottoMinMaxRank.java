import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int equal = 0;
        for(int i = 0; i < lottos.length; i++) {
            for(int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) equal++;
            }
        }

        int zeroNum = 0;
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) zeroNum++;
        }

        int maxRank = 7 - (zeroNum + equal);
        int minRank = 7 - equal;

        maxRank = maxRank > 5 ? 6 : maxRank;
        minRank = minRank > 5 ? 6 : minRank;

        int[] answer = {maxRank, minRank};
        return answer;
    }
}