import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long K = Long.parseLong(br.readLine());
        br.close();

        long left = 1, right = K, mid;

        while(left < right) {
            mid = (left + right) / 2;
            long count = 0;
            for(int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if(K > count) left = mid + 1;
            else right = mid;
        }

        System.out.print(left);
    }
}