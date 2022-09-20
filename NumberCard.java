import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberCard {

    public static void main(String[] args) throws IOException {
        int[][] dp = new int[41][3];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        br.close();

        dp[1][1] = 1;
        int prev = (input[0] - '0') * 10;
        for(int i = 2; i <= input.length; i++) {
            int cur = input[i - 1] - '0';
            if(cur == 0) {
                if(prev + cur < 35) {
                    dp[i][2] = dp[i - 1][1];
                }
                continue;
            }

            if(prev + cur < 35) {
                dp[i][1] = dp[i - 1][1] + dp[i - 1][2];
                dp[i][2] = dp[i - 1][1];
            }
            else dp[i][1] = dp[i - 1][1] + dp[i - 1][2];

            prev = cur * 10;
        }

        System.out.println(dp[input.length][1] + dp[input.length][2]);
    }
}
