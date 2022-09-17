import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        int[] arr = new int[N + 1];
        int sum = 0;
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            if(arr[i] >= S) {
                System.out.println(1);
                return;
            }
            sum += arr[i];
        }
        br.close();

        if(sum < S) {
            System.out.println(0);
            return;
        }

        if(sum == S) {
            System.out.println(N);
            return;
        }

        int start = 0;
        int end = 0;
        int total = 0;
        int minLen = Integer.MAX_VALUE;

        while(start <= N && end <= N) {
            if(total >= S && minLen > end - start) minLen = end - start;

            if(total < S) total += arr[end++];
            else total -= arr[start++];
        }

        System.out.println(minLen);
    }
}
