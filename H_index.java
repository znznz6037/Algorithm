import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int h_index = 0;
        for(int i = 0; i < citations.length; i++){
            h_index = citations.length - i;
            if(citations[i] >= h_index) {
                answer = h_index;
                break;
            }
        }
        return answer;
    }
}