import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
                
        for(long i = 0; i <= d; i += k) {
            long maxY = (long)Math.sqrt((long)d * d - (long)i * i); //d*d, i*i long으로 형변환 안하면 오버플로우 발생
            answer += maxY / k + 1;
        }
        
        return answer;
    }
}
