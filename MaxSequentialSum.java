import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxSequentialSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for(int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int answer = dp[0];
        for(int i = 1; i < N; i++) {
            int sequential = dp[i - 1] + dp[i];
            if(dp[i] < sequential) {
                dp[i] = sequential;
            }

            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}