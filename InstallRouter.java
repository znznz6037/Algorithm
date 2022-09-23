import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InstallRouter {
    static int N, C;
    static int[] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        home = new int[N];
        for(int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(home);

        int mid;
        int left = 1;
        int right = home[N -1] - home[0];
        int answer = 0;

        while(left <= right) {
            mid = (left + right) / 2;

            int count = 1;
            int prev = home[0];
            for(int i = 1; i < N; i++) {
                if(home[i] - prev >= mid) {
                    count++;
                    prev = home[i];
                }
            }

            if(count >= C) {
                answer = mid;
                left = mid + 1;
            }
            else if(count < C) {
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }
}
