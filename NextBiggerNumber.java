class Solution {
    public int solution(int n) {
        int cnt = countOfOne(n);

        while(cnt != countOfOne(++n));

        return n;
    }

    public int countOfOne(int n) {
        int cnt = 0;
        int len = 1;
        while(Math.pow(2, len++) < n);

        for(int i = len; i >= 0; i--) {
            if(n >= Math.pow(2, i)) {
                n -= Math.pow(2, i);
                cnt++;
            }
        }

        return cnt++;
    }
}