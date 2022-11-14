import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] input = br.readLine().split(" ");
        br.close();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int ascend_dp[] = new int[N];
        int descend_dp[] = new int[N];

        for(int i = 0; i < N; i++) {
            LIS(i, ascend_dp);
            LDS(i, descend_dp);
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            answer = Math.max(answer, ascend_dp[i] + descend_dp[i]);
        }
        System.out.println(answer - 1);
    }

    public static int LIS(int cur, int[] dp) {
        if(dp[cur] == 0) {
            dp[cur] = 1;

            for(int i = cur - 1; i >= 0; i--) {
                if(arr[cur] > arr[i]) {
                    dp[cur] = Math.max(dp[cur], LIS(i, dp) + 1);
                }
            }
        }

        return dp[cur];
    }

    public static int LDS(int cur, int[] dp) {
        if(dp[cur] == 0) {
            dp[cur] = 1;

            for(int i = cur + 1; i < dp.length; i++) {
                if(arr[cur] > arr[i]) {
                    dp[cur] = Math.max(dp[cur], LDS(i, dp) + 1);
                }
            }
        }

        return dp[cur];
    }
}
