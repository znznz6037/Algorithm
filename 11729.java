import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hanoi {
    static StringBuilder answer;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        K = 0;
        answer = new StringBuilder();

        recur(N, 1, 2, 3);

        System.out.print(K + "\n" + answer.toString());
    }

    public static void recur(int N, int from, int via, int to) {
        if(N == 1) move(from, to);
        else {
            recur(N - 1, from, to, via);
            move(from, to);
            recur(N - 1, via, from, to);
        }
    }

    public static void move(int from, int to) {
        K++;
        answer.append(from + " " + to + "\n");
    }
}
