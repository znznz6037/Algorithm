import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class History {
    public static void main(String[] args) throws IOException {
        final int INF = 100000;
        int n, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        int[][] history = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) Arrays.fill(history[i], INF);

        for(int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int fr = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            history[fr][to] = 1;
        }

        for(int l = 1; l <= n; l++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == j) continue;
                    history[i][j] = Math.min(history[i][j], history[i][l] + history[l][j]);
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s; i++) {
            input = br.readLine().split(" ");
            int fr = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            if(history[fr][to] != INF) sb.append("-1\n");
            else if(history[to][fr] != INF) sb.append("1\n");
            else sb.append("0\n");
        }

        br.close();

        System.out.print(sb);
    }
}
