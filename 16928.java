import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadderGame {
    static class Pos {
        int pos;
        int cnt;

        public Pos(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        int N, M;
        int[] ladder = new int[101];
        int[] snake = new int[101];
        boolean[] visited = new boolean[101];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            ladder[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
        }

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            snake[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
        }

        br.close();

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(1, 0));

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();
            visited[cur.pos] = true;
            if(cur.pos == 100) {
                System.out.println(cur.cnt);
                break;
            }

            for(int num = 1; num <= 6; num++) {
                int next = cur.pos + num;
                if(next > 100) continue;
                if(ladder[next] != 0) queue.add(new Pos(ladder[next], cur.cnt + 1));
                else if(snake[next] != 0) queue.add(new Pos(snake[next], cur.cnt + 1));
                else if(!visited[next]) queue.add(new Pos(next, cur.cnt + 1));
            }
        }
    }
}
