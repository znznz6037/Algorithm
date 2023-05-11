import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int H = Integer.parseInt(input[1]);
        int[] top = new int[H + 1];
        int[] bottom = new int[H + 1];

        for(int i = 0; i < N; i++) {
            int len = Integer.parseInt(br.readLine());
            if(i % 2 == 0) bottom[len]++;
            else top[len]++;
        }
        br.close();

        for(int i = H - 1; i > 0; i--) {
            top[i] += top[i + 1];
            bottom[i] += bottom[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 1; i <= H; i++) {
            int count = top[i] + bottom[H - i + 1];

            if(min > count) {
                min = count;
                answer = 1;
            }
            else if(min == count) answer++;
        }

        System.out.println(min + " " + answer);
    }
}