import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int N, K, answer;
    static int[] dist;
    static class Subin {
        int pos;
        int sec;

        Subin(int pos, int sec) {
            this.pos = pos;
            this.sec = sec;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        br.close();
        if(N == K) {
            System.out.print(0);
            return;
        }

        if(N > K) {
            System.out.print(N - K);
            return;
        }

        dist = new int[100001];
        for(int i = 0; i < 100001; i++) dist[i] = Integer.MAX_VALUE;

        dist[N] = 0;
        dijkstra(N);

        System.out.print(answer);
    }

    public static void dijkstra(int N) {
        PriorityQueue<Subin> pq = new PriorityQueue<>(((o1, o2) -> o1.sec - o2.sec));
        pq.add(new Subin(N, 0));

        while(!pq.isEmpty()) {
            Subin curPos = pq.poll();
            if(curPos.pos == K) {
                answer = dist[curPos.pos];
            }

            if(curPos.pos > 0) {
                if(dist[curPos.pos - 1] > dist[curPos.pos] + 1) {
                    dist[curPos.pos - 1] = dist[curPos.pos] + 1;
                    pq.add(new Subin(curPos.pos - 1, dist[curPos.pos - 1]));
                }
            }

            if(curPos.pos < 100000) {
                if(dist[curPos.pos + 1] > dist[curPos.pos] + 1) {
                    dist[curPos.pos + 1] = dist[curPos.pos] + 1;
                    pq.add(new Subin(curPos.pos + 1, dist[curPos.pos + 1]));
                }
            }

            if(curPos.pos != 0 && curPos.pos * 2 <= 100000) {
                if(dist[curPos.pos * 2] > dist[curPos.pos]) {
                    dist[curPos.pos * 2] = dist[curPos.pos];
                    pq.add(new Subin(curPos.pos * 2, dist[curPos.pos]));
                }
            }
        }
    }
}
