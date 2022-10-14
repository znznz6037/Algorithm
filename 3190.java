import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Snake {

    static int N;
    static int K;
    static int L;
    static int d = 0;
    static int[][] map;
    static int[][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    static Map<Integer,String> moveInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        moveInfo = new HashMap<>();

        for(int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");

            int y = Integer.parseInt(input[0])-1;
            int x = Integer.parseInt(input[1])-1;
            map[y][x] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");

            int time = Integer.parseInt(input[0]);
            String dir = input[1];
            moveInfo.put(time, dir);
        }
        br.close();

        solve();
    }

    public static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int time =0;
        int cy =0;
        int cx =0;

        while(!queue.isEmpty()) {
            int ny = cy + dir[d][0];
            int nx = cx + dir[d][1];
            time++;

            if(nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) break;
            if(queue.contains(ny * N + nx)) break;

            if(map[ny][nx] == 1) {
                map[ny][nx] = 0;
                queue.add(ny * N + nx);
            }
            else {
                queue.add(ny * N + nx);
                queue.poll();
            }

            if(moveInfo.containsKey(time)) {
                String data = moveInfo.get(time);

                if(data.equals("D")) {
                    d += 1;
                    if(d == 4) d = 0;
                }
                else {
                    d -= 1;
                    if(d == -1) d = 3;
                }
            }

            cx = nx;
            cy = ny;
        }

        System.out.println(time);
    }
}