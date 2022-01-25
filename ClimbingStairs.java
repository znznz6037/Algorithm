class Solution {
    public int climbStairs(int n) {
        int solution = 0;

        int[][] memo = new int[45][45];

        int cnt = n / 2;
        for(int i = 0; i <= cnt; i++) {
            solution += combination(n - i, i, memo);
        }

        return solution;
    }

    public int combination(int n, int r, int[][] memo) {
        if(r == 0 || r == n) return 1;
        if(r == 1) return n;
        if(memo[n][r] != 0) return memo[n][r];

        return memo[n][r] = combination(n - 1, r - 1, memo) + combination(n -1, r, memo);
    }
}