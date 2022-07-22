import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cone1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int[] coins = new int[n];
        int[] dp = new int[k + 1];

        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        dp[0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.print(dp[k]);
    }
}
