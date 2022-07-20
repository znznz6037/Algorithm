import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddOneTwoThree {
    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(getCnt(n) + "\n");
        }
        br.close();

        System.out.print(sb);
    }
    public static int getCnt(int n) {
        if(dp[n] != 0) return dp[n];

        return getCnt(n - 1) + getCnt(n - 2) + getCnt(n - 3);
    }
}
