import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HideAndSeek {
    static int N, K;
    static boolean[] visited;

    static class Position {
        int pos;
        int sec;

        Position(int pos, int sec) {
            this.pos = pos;
            this.sec = sec;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        br.close();

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        visited = new boolean[100001];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(N, 0));
        visited[N] = true;
        while(!queue.isEmpty()) {
            Position position = queue.poll();
            visited[position.pos] = true;
            if(position.pos == K) {
                System.out.print(position.sec);
                return;
            }
            if(position.pos > 0 && !visited[position.pos - 1]) queue.add(new Position(position.pos - 1, position.sec + 1));
            if(position.pos < 100000 && !visited[position.pos + 1]) queue.add(new Position(position.pos + 1, position.sec + 1));
            if(position.pos * 2 <= 100000 && !visited[position.pos * 2]) queue.add(new Position(position.pos * 2, position.sec + 1));
        }
    }
}
