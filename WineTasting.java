import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting {
    public static void main(String[] args) throws IOException {
        int N = 0;
        int answer = 0;
        int[] dp;
        int[] wineList;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        wineList = new int[N];

        for(int i = 0; i < N; i++) wineList[i] = Integer.parseInt(br.readLine());

        br. close();

        if(N <= 2) {
            if(N == 1) System.out.print(wineList[0]);
            else System.out.print(wineList[0] + wineList[1]);

            return;
        }

        dp[0] = wineList[0];
        dp[1] = wineList[0] + wineList[1];
        dp[2] = Math.max(dp[1], Math.max(wineList[0] + wineList[2], wineList[1] + wineList[2]));
        answer = Math.max(dp[0], Math.max(dp[1], dp[2]));

        for(int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 3] + wineList[i - 1] + wineList[i], Math.max(dp[i - 2] + wineList[i], dp[i - 1]));
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}
