import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    static int R, C;
    static char[][] words;
    static int answer = 0;
    static int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        words = new char[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                words[i][j] = str.charAt(j);
            }
        }
        br.close();

        Map<Character, Integer> map = new HashMap<>();
        map.put(words[0][0], 1);
        dfs(0, 0, 1, map);
        System.out.println(answer);
    }

    public static void dfs(int y, int x, int cnt, Map<Character, Integer> map) {
        answer = Math.max(answer, cnt);

        for(int i = 0; i < 4; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];
            if(ny >= 0 && ny < R && nx >= 0 && nx < C && !map.containsKey(words[ny][nx])) {
                map.put(words[ny][nx], 1);
                dfs(ny, nx, cnt + 1, map);
                map.remove(words[ny][nx]);
            }
        }
    }
}
