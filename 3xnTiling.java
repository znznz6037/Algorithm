class Solution {
    public int solution(int n) {
        int answer = 0;

        long[] dp = new long[n + 1];
        dp[2] = 3;
        dp[4] = 11;

        for(int i = 4; i <= n; i++) {
            if(i % 2 == 0) {
                dp[i] = dp[i - 2] * 3 + 2;
                for(int j = i - 4; j >= 2; j--) {
                    dp[i] += dp[j] * 2;
                }
            }
            dp[i] %= 1000000007;
        }

        return (int)dp[n];
    }
}