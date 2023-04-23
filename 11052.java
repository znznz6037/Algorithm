import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        br.close();

        int[] P = new int[input.length + 1];
        for(int i = 0; i < input.length; i++) {
            P[i + 1] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[N + 1];
        dp[1] = P[1];
        for(int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + P[1], P[i]);
            for(int j = 1; j < i; j++) {
                int idx = i - j;
                dp[i] = Math.max(dp[i], dp[j] + dp[idx]);
            }
        }
        System.out.println(dp[N]);
    }
}