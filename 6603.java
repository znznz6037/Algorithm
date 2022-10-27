import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lotto {
    public static void main(String[] args) throws IOException {

        int[] S;
        String[] input;
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            input  = br.readLine().split(" ");
            if(input.length == 1) break;

            int k = Integer.parseInt(input[0]);
            S = new int[k];
            for (int i = 1; i < input.length; i++) {
                S[i - 1] = Integer.parseInt(input[i]);
            };

            boolean[] visited = new boolean[k];
            getTotalCase(0, 0, S, visited, sb);
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void getTotalCase(int depth, int start, int[] S, boolean[] visited, StringBuilder sb) {
        if(depth == 6) {
            for(int i = 0; i < S.length; i++) {
                if(visited[i]) sb.append(S[i] + " ");
            }
            sb.append("\n");

            return;
        }

        for(int i = start; i < S.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                getTotalCase(depth + 1, i + 1, S, visited, sb);
                visited[i] = false;
            }
        }
    }
}
