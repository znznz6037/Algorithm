import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        if(N == 1) {
            System.out.println("1");
            return;
        }

        long[] dp = new long[N + 1];
        dp[1] = 1; dp[2] = 1;

        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(solution(N, dp));
    }

    public static long solution(int n, long[] dp) {
        if(dp[n] != 0) return dp[n];

        return dp[n] = solution(n - 1, dp) + solution(n - 2, dp);
    }
}
