import java.util.*;

class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        return min + " " + max;
    }
}