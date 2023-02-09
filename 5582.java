import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommonString {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        br.close();

        if(str1.length() == 1 || str2.length() == 1) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        int[][] map = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 1; i <= str1.length(); i++) {
            for(int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }

        System.out.println(answer);
    }
}
