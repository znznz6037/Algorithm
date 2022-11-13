import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N];
        int wires[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            dp[i] = -1;

            String[] input = br.readLine().split(" ");
            wires[i] = new int[]{Integer.valueOf(input[0]), Integer.valueOf(input[1])};
        }
        br.close();

        Arrays.sort(wires, (o1, o2) -> o1[0] - o2[0]);

        int maxWireCnt = 0;
        for(int i = 0; i < N; i++) {
            maxWireCnt = Math.max(maxWireCnt, getMaxWireCnt(i, wires));
        }

        System.out.println(N - maxWireCnt);
    }

    public static int getMaxWireCnt(int num, int[][] wires) {
        if(dp[num] == -1) {
            dp[num] = 1;
            for (int i = num + 1; i < dp.length; i++) {
                if (wires[num][1] < wires[i][1]) {
                    dp[num] = Math.max(dp[num], getMaxWireCnt(i, wires) + 1);
                }
            }
        }

        return dp[num];
    }
}