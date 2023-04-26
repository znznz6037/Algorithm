import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        if(N <= 2) {
            System.out.println(0);
            return;
        }

        String[] input = br.readLine().split(" ");
        br.close();

        for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(input[i]);
        Arrays.sort(numbers);

        int answer = 0;
        for(int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            int pivot = numbers[i];
            while(true) {
                if(left == i) left++;
                else if(right == i) right--;

                if(left >= right) break;

                if(isOverflow(numbers[left], numbers[right])) right--;
                int result = numbers[left] + numbers[right];

                if(result < pivot) left++;
                else if(result > pivot) right--;
                else {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean isOverflow(int a, int b) {
        if(a == 0 || b == 0) return false;

        if(b > 0) {
            if(a > Integer.MAX_VALUE - b) return true;
        }
        else {
            if(a < Integer.MIN_VALUE - b) return true;
        }

        return false;
    }
}
