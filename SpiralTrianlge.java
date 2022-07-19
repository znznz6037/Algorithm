import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiralTriangle {
    static long[] memo = new long[101];

    public static void main(String[] args) throws IOException {
        memo[1] = memo[2] = memo[3] = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] rep = new int[T];

        for(int i = 0; i < T; i++) rep[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) System.out.println(spiral(rep[i]));
        br.close();
    }

    public static long spiral(int N) {
        if(memo[N] != 0) return memo[N];

        for(int i = 4; i <= N; i++) {
            if(memo[i] == 0) {
                memo[i] = memo[i - 2] + memo[i - 3];
            }
        }
        return memo[N];
    }
}
