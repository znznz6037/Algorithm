import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        br.close();

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[][] dp = new int[N + 1][K + 1];

        for(int i = 0; i <= N; i++) dp[i][1] = 1;
        for(int i = 0; i <= K; i++) dp[1][i] = i;

        if(N == 1 || K == 1) {
            System.out.println(dp[N][K]);
            return;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }

        System.out.println(dp[N][K]);
    }
}