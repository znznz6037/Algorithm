import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumberCard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cardsMap = new HashMap<>();

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            cardsMap.put(num, cardsMap.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        int[] answers = new int[M];
        input = br.readLine().split(" ");

        br.close();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(input[i]);
            sb.append(cardsMap.getOrDefault(target, 0) + " ");
        }

        System.out.print(sb);
    }
}