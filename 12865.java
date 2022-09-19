import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NormalBag {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];
        long[] dp = new long[K + 1];

        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            weights[i] = Integer.parseInt(input[0]);
            values[i] = Integer.parseInt(input[1]);
        }
        br.close();

        for(int i = 0; i < N; i++) {
            for(int j = K; j - weights[i]>= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        System.out.println(dp[K]);
    }
}
