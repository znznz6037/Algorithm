class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;

        for(int[] curProblem: problems) {
            maxAlp = Math.max(maxAlp, curProblem[0]);
            maxCop = Math.max(maxCop, curProblem[1]);
        }

        if(alp >= maxAlp && cop >= maxCop) return 0;
        if(alp >= maxAlp) alp = maxAlp;
        if(cop >= maxCop) cop = maxCop;

        int[][] dp = new int[maxAlp + 2][maxCop + 2];
        for(int i = alp; i <= maxAlp; i++) {
            for(int j = cop; j <= maxCop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[alp][cop] = 0;
        for(int i = alp; i <= maxAlp; i++) {
            for(int j = cop; j <= maxCop; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for(int[] curProblem: problems) {
                    if(i >= curProblem[0] && j >= curProblem[1]) {
                        if(i + curProblem[2] > maxAlp && j + curProblem[3] > maxCop) {
                            dp[maxAlp][maxCop] = Math.min(dp[maxAlp][maxCop], dp[i][j] + curProblem[4]);
                        }
                        else if(i + curProblem[2] > maxAlp) {
                            dp[maxAlp][j + curProblem[3]] = Math.min(dp[maxAlp][j + curProblem[3]], dp[i][j] + curProblem[4]);
                        }
                        else if(j + curProblem[3] > maxCop) {
                            dp[i + curProblem[2]][maxCop] = Math.min(dp[i + curProblem[2]][maxCop], dp[i][j] + curProblem[4]);
                        }
                        else if(i + curProblem[2] <= maxAlp && j + curProblem[3] <= maxCop) {
                            dp[i + curProblem[2]][j + curProblem[3]] = Math.min(dp[i + curProblem[2]][j + curProblem[3]], dp[i][j] + curProblem[4]);
                        }
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}