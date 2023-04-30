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

        System.out.println(combination(dp, N, K));
    }

    public static int combination(int[][] dp, int n, int k) {
        if(dp[n][k] != 0) return dp[n][k];
        if(n == k || k == 0) return dp[n][k] = 1;
        return dp[n][k] = (combination(dp, n - 1, k) + combination(dp, n - 1, k - 1)) % 10007;
    }
}
