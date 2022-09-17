import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeightSequence {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        boolean[][] height = new boolean[N + 1][N + 1];
        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            height[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(height[i][k] && height[k][j]) height[i][j] = true;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            boolean isAnswer = true;
            for(int j = 1; j <= N; j++) {
                if(i == j) continue;
                if(!height[i][j] && !height[j][i]) {
                    isAnswer = false;
                    break;
                }
            }
            if(isAnswer) answer++;
        }

        System.out.print(answer);
    }
}
