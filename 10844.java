import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] dp;
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];

        br.close();

        for(int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        long answer = 0;
        for(int i = 1; i <= 9; i++) {
            answer += getCount(N, i);
        }

        System.out.println(answer % MOD);
    }
    public static long getCount(int pos, int num) {
        if(pos == 1) return dp[pos][num];

        if(dp[pos][num] == 0) {
            if(num == 0) dp[pos][num] = getCount(pos - 1, 1);
            else if(num == 9) dp[pos][num] = getCount(pos - 1, 8);
            else {
                dp[pos][num] = getCount(pos - 1, num - 1) + getCount(pos - 1, num + 1);
            }
        }

        return dp[pos][num] % MOD;
    }
}
