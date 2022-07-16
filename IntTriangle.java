import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntTriangle {
    static int N;
    static int[][] triangle;
    static int[][] dp;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        dp = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        dp[0][0] = triangle[0][0];
        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) dp[i][j] = dp[i - 1][0] + triangle[i][j];
                else if(j == i) dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                else {
                    int left = dp[i - 1][j - 1] + triangle[i][j];
                    int right = dp[i - 1][j] + triangle[i][j];
                    dp[i][j] = Math.max(left, right);
                }
            }
        }

        for(int i = 0; i < N; i++) answer = Math.max(answer, dp[N - 1][i]);
        System.out.print(answer);
    }
}