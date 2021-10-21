import java.io.*;

public class BOJ11724 {
    static int answer = 0, N = 0, M = 0;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);
            int[][] map = new int[N][N];
            boolean[] visited = new boolean[N];

            for(int i = 0; i < M; i++) {
                str = br.readLine().split(" ");
                map[Integer.parseInt(str[0]) - 1][Integer.parseInt(str[1]) - 1] =
                        map[Integer.parseInt(str[1]) - 1][Integer.parseInt(str[0]) - 1] = 1;
            }

            for(int i = 0; i < N; i++) {
                if(!visited[i]) {
                    answer++;
                    DFS(map, i, visited);
                }
            }

            System.out.print(answer);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void DFS(int[][] map, int curV, boolean[] visited) {
        visited[curV] = true;
        for(int i = 0; i < N; i++) {
            if(!visited[i] && map[curV][i] == 1) DFS(map, i, visited);
        }
    }
}
