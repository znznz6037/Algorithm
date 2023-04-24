import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] score = new int[2][n];
            for(int j = 0; j < 2; j++) {
                String[] input = br.readLine().split(" ");
                for(int k = 0; k < n; k++) {
                    score[j][k] = Integer.parseInt(input[k]);
                }
            }

            System.out.println(maxScore(score, n));
        }
        br.close();
    }

    public static int maxScore(int[][] score, int length) {
        int[][] dp = new int[2][length];

        for(int i = 0; i < 2; i++) {
            dp[0][0] = score[0][0];
            dp[1][0] = score[1][0];
            if(length == 1) return Math.max(dp[0][0], dp[1][0]);

            dp[0][1] = dp[1][0] + score[0][1];
            dp[1][1] = dp[0][0] + score[1][1];
            if(length == 2) return Math.max(dp[0][1], dp[1][1]);

            for(int n = 2; n < length; n++) {
                dp[0][n] = Math.max(dp[1][n - 1] + score[0][n], Math.max(dp[0][n - 2] + score[0][n], dp[1][n - 2] + score[0][n]));
                dp[1][n] = Math.max(dp[0][n - 1] + score[1][n], Math.max(dp[0][n - 2] + score[1][n], dp[1][n - 2] + score[1][n]));
            }
        }

        return Math.max(dp[0][length - 1], dp[1][length - 1]);
    }
}
