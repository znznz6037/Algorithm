import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length + queue2.length;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i: queue1) {
            q1.add(i);
            sum1 += i;
        }

        for(int i: queue2) {
            q2.add(i);
            sum2 += i;
        }

        int cnt = 0;
        while(true) {
            if(cnt > len + 2) return -1;
            if(sum1 == sum2) return cnt;

            int n = 0;
            if(sum1 > sum2) {
                n = q1.poll();
                q2.add(n);
                sum1 -= n;
                sum2 += n;
            }
            else {
                n = q2.poll();
                q1.add(n);
                sum1 += n;
                sum2 -= n;
            }

            cnt++;
        }
    }
}