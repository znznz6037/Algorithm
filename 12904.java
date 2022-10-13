import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AandB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        br.close();

        StringBuilder sb = new StringBuilder(T);
        int rep = T.length();
        while(rep-- >= 0) {
            if(rep + 1 == S.length()) {
                if(sb.toString().equals(S)) System.out.print(1);
                else System.out.println(0);
                return;
            }

            if(sb.charAt(rep) == 'B') {
                sb.deleteCharAt(rep);
                sb.reverse();
            }
            else sb.deleteCharAt(rep);
        }
    }
}
