import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] input = br.readLine().split(" ");
        br.close();

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        if(N == 1) {
            System.out.println(A[0]);
            return;
        }

        int answer = A[0];
        int[] dp = new int[N];
        dp[0] = A[0];
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(A[i] < A[j]) {
                    dp[j] = Math.max(dp[j], Math.max(dp[i] + A[j], A[i] + A[j]));
                }
            }
        }

        for(int i: dp)  {
            answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }
}
