import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine(). split(" ");
        long answer = 0;
        int N = Integer.parseInt(input[0]);
        long[] distances = new long[N - 1];
        int[] prices = new int[N];

        input = br.readLine().split(" ");
        for(int i = 0; i < N - 1; i++) {
            distances[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(input[i]);
        }

        br.close();

        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < N - 1; i++) {
            if(prices[i] < minPrice) minPrice = prices[i];
            answer += minPrice * distances[i];
        }

        System.out.println(answer);
    }
}