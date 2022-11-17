import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[][][]dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        dp = new Integer[51][51][51];

        while(true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            if(a == -1 && b == -1 && c == -1) break;

            answer.append(output(a, b, c, recur(a, b, c)));
        }
        br.close();

        System.out.println(answer);
    }

    public static StringBuilder output(int a, int b, int c, int result) {
        StringBuilder sb = new StringBuilder();

        sb.append("w(" + a + ", ");
        sb.append(b + ", ");
        sb.append(c + ") = " + result + "\n");

        return sb;
    }

    public static int recur(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if(a > 20 || b > 20 || c > 20) {
            if(dp[a][b][c] != null) return dp[a][b][c];
            return dp[20][20][20] = recur(20, 20, 20);
        }
        if(a < b && b < c) {
            if(dp[a][b][c] != null) return dp[a][b][c];
            return dp[a][b][c] = recur(a, b, c - 1) + recur(a, b - 1, c - 1) - recur(a, b - 1, c);
        }
        else {
            if(dp[a][b][c] != null) return dp[a][b][c];
            return dp[a][b][c] = recur(a - 1, b, c) + recur(a - 1, b - 1, c) + recur(a - 1, b, c - 1) - recur(a - 1, b - 1, c - 1);
        }
    }
}
