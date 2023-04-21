import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        if(n == 1) {
            System.out.println("1");
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 3;

        System.out.println(solution(n, dp));
    }

    public static int solution(int n, int[] dp) {
        if(dp[n] != 0) return dp[n];

        return dp[n] = (solution(n - 1, dp) + solution(n - 2, dp) * 2) % 10007;
    }
}
