import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AlgoSpot {
    static int N, M;
    static int[][] map;
    static int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    private static class Point {
        int y;
        int x;
        int count;

        Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();

        BFS();
    }

    public static void BFS() {
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1.count - o2.count));
        priorityQueue.add(new Point(0, 0, 0));

        boolean[][] visited = new boolean[N][M];

        while(!priorityQueue.isEmpty()) {
            Point point = priorityQueue.poll();
            if(point.count > 200) continue;
            if(point.y == N - 1 && point.x == M - 1) {
                System.out.println(point.count);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int ny = point.y + dir[i][0];
                int nx = point.x + dir[i][1];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;

                if(map[ny][nx] == 1) priorityQueue.add(new Point(ny, nx, point.count + 1));
                else priorityQueue.add(new Point(ny, nx, point.count));
                visited[ny][nx] = true;
            }
        }
    }
}
